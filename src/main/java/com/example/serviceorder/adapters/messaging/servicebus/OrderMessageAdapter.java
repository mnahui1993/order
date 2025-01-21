package com.example.serviceorder.adapters.messaging.servicebus;

import com.azure.messaging.servicebus.ServiceBusClientBuilder;
import com.azure.messaging.servicebus.ServiceBusMessage;
import com.azure.messaging.servicebus.ServiceBusSenderAsyncClient;
import com.example.serviceorder.adapters.messaging.servicebus.mapper.OrderMessageMapper;
import com.example.serviceorder.application.ports.output.OrderMessagingPort;
import com.example.serviceorder.domain.errors.OrderMessageAdapterException;
import com.example.serviceorder.domain.model.Order;
import com.example.serviceorder.utils.JsonUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
@Slf4j
public class OrderMessageAdapter implements OrderMessagingPort {
    @Value("${spring.cloud.azure.servicebus.connection-string}")
    private  String connectionString;
    @Value("${spring.cloud.azure.servicebus.queue-name}")
    private  String queueName;

    private final OrderMessageMapper orderMessageMapper;

    @Override
    public Mono<Void> sendOrderConfirmationMessage(Order order) {

        var  messageContent = JsonUtils.serializeJson(orderMessageMapper.toOrderMessage(order));
        return Mono.defer(() -> {

            // Crear cliente reactivo para enviar el mensaje a Azure Service Bus
            ServiceBusSenderAsyncClient senderClient = new ServiceBusClientBuilder()
                    .connectionString(connectionString)
                    .sender()
                    .queueName(queueName)
                    .buildAsyncClient();

            // Crear el mensaje con el contenido serializado
            ServiceBusMessage message = new ServiceBusMessage(messageContent);

            // Enviar el mensaje de forma reactiva
            return  senderClient.sendMessage(message);
            }) .doOnSuccess(res -> log.info("Mensaje enviado {}  a cola {} ",messageContent,queueName))
                .doOnError(e -> log.error("Error al enviar mensaje hacia la cola {} ",queueName , e))
                .onErrorMap(e -> new OrderMessageAdapterException("Error al enviar pedido a Azure Service Bus", e)); //

    }
}
