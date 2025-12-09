package nuts.study.msa_saga.orderservice.infrastructure.saga;

import lombok.RequiredArgsConstructor;
import nuts.study.msa_saga.orderservice.application.message.OrderSagaMessage;
import nuts.study.msa_saga.orderservice.application.provided.SagaEventProcessor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaSagaListener {

    private final SagaEventProcessor sagaEventProcessor;

    @KafkaListener(
            topics = "order-event",
            groupId = "order-service"
    )
    public void listenPaymentApproved(OrderSagaMessage sagaMessage) {
        sagaEventProcessor.processEvent(sagaMessage);
    }
}