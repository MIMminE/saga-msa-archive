package nuts.study.msa_saga.orderservice.adapter.outbound.messaging;

import nuts.study.msa_saga.orderservice.application.outbox.message.OrderCreationOutboxMessage;
import nuts.study.msa_saga.orderservice.application.port.messaging.OutboxPublisher;
import org.springframework.stereotype.Component;

@Component
public class KafkaOrderCreatePublisher implements OutboxPublisher<OrderCreationOutboxMessage> {

    @Override
    public void publish(OrderCreationOutboxMessage outboxMessage) {

    }
}