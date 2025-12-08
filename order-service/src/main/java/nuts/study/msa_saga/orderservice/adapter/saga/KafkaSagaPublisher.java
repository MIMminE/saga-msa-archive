package nuts.study.msa_saga.orderservice.adapter.saga;

import nuts.study.msa_saga.orderservice.application.message.OrderSagaMessage;
import nuts.study.msa_saga.orderservice.required.saga.SagaMessagePublisher;
import org.springframework.stereotype.Component;

@Component
public class KafkaSagaPublisher implements SagaMessagePublisher {

    @Override
    public void publish(OrderSagaMessage message) {

    }
}
