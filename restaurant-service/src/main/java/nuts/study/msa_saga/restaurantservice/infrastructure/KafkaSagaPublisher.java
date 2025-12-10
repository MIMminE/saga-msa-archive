package nuts.study.msa_saga.restaurantservice.infrastructure;

import nuts.study.msa_saga.restaurantservice.application.message.OrderSagaMessage;
import nuts.study.msa_saga.restaurantservice.application.required.SagaMessagePublisher;

public class KafkaSagaPublisher implements SagaMessagePublisher {

    @Override
    public void publish(OrderSagaMessage message) {

    }
}
