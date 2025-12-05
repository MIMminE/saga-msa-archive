package nuts.study.msa_saga.orderservice.adapter.outbox;

import nuts.study.msa_saga.orderservice.application.message.OrderApprovalOutboxMessage;
import nuts.study.msa_saga.orderservice.application.required.outbox.OutboxMessagePublisher;
import org.springframework.stereotype.Component;

@Component
public class KafkaApprovalMessagePublisher implements OutboxMessagePublisher<OrderApprovalOutboxMessage> {

    @Override
    public void publish(OrderApprovalOutboxMessage message) {

    }
}