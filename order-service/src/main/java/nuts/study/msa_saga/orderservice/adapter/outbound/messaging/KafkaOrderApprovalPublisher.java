package nuts.study.msa_saga.orderservice.adapter.outbound.messaging;

import nuts.study.msa_saga.orderservice.application.outbox.message.OrderApprovalOutboxMessage;
import nuts.study.msa_saga.orderservice.application.port.messaging.OutboxPublisher;

public class KafkaOrderApprovalPublisher implements OutboxPublisher<OrderApprovalOutboxMessage> {

    @Override
    public void publish(OrderApprovalOutboxMessage outboxMessage) {

    }
}
