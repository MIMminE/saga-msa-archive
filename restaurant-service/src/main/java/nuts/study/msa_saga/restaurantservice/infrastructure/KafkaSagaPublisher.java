package nuts.study.msa_saga.restaurantservice.infrastructure;

import nuts.study.msa_saga.restaurantservice.application.message.OrderSagaMessage;
import nuts.study.msa_saga.restaurantservice.application.required.SagaMessagePublisher;
import org.springframework.stereotype.Component;

@Component
public class KafkaSagaPublisher implements SagaMessagePublisher {

    private final KafkaSagaPublisher<> kafkaSagaPublisher;

    @Override
    public void publish(OrderSagaMessage message) {

    }
}
