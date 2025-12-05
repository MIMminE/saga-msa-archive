package nuts.study.msa_saga.orderservice.application.required.outbox;

import nuts.study.msa_saga.orderservice.application.message.OutboxMessage;

public interface OutboxMessagePublisher<T extends OutboxMessage> {
    void publish(T message);
}
