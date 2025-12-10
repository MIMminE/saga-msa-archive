package nuts.study.msa_saga.restaurantservice.application.required;

import nuts.study.msa_saga.restaurantservice.application.message.OrderSagaMessage;

public interface SagaMessagePublisher {
    void publish(OrderSagaMessage message);
}
