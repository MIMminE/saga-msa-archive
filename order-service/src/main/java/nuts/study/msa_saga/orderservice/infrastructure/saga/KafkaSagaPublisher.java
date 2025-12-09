package nuts.study.msa_saga.orderservice.infrastructure.saga;

import nuts.study.msa_saga.orderservice.application.message.OrderSagaMessage;
import nuts.study.msa_saga.orderservice.application.required.saga.SagaMessagePublisher;
import org.springframework.stereotype.Component;

@Component
public class KafkaSagaPublisher implements SagaMessagePublisher {

    @Override
    public void publish(OrderSagaMessage message) {

    }
}
