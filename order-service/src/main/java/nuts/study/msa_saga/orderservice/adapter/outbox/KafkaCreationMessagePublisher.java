package nuts.study.msa_saga.orderservice.adapter.outbox;

import nuts.study.msa_saga.orderservice.application.message.OrderCreationOutboxMessage;
import nuts.study.msa_saga.orderservice.application.required.outbox.OutboxMessagePublisher;
import org.springframework.stereotype.Component;

@Component
public class KafkaCreationMessagePublisher implements OutboxMessagePublisher<OrderCreationOutboxMessage> {
    @Override
    public void publish(OrderCreationOutboxMessage message) {

    }
}
