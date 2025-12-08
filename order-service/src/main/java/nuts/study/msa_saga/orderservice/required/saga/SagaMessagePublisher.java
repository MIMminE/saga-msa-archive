package nuts.study.msa_saga.orderservice.required.saga;

import nuts.study.msa_saga.orderservice.application.message.OrderSagaMessage;

public interface SagaMessagePublisher {
    void publish(OrderSagaMessage message);
}