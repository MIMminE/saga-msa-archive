package nuts.study.msa_saga.orderservice.application.required.saga;

import nuts.study.msa_saga.orderservice.application.message.OrderSagaMessage;

public interface SagaMessagePublisher {
    void publish(OrderSagaMessage message);
}