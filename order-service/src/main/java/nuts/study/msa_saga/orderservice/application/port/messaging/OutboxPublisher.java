package nuts.study.msa_saga.orderservice.application.port.messaging;

import nuts.study.msa_saga.orderservice.application.outbox.message.OutboxMessage;

public interface OutboxPublisher<T extends OutboxMessage> {
    void publish(T outboxMessage);
}
