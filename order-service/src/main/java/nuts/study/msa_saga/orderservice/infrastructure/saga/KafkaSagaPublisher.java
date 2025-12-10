package nuts.study.msa_saga.orderservice.infrastructure.saga;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nuts.study.msa_saga.orderservice.application.message.OrderSagaMessage;
import nuts.study.msa_saga.orderservice.application.required.saga.SagaMessagePublisher;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class KafkaSagaPublisher implements SagaMessagePublisher {

    private final KafkaTemplate<String, OrderSagaMessage> kafkaTemplate;

    @Override
    public void publish(OrderSagaMessage message) {
        kafkaTemplate.send("restaurant-event", message);
        log.info("Published saga message to Kafka: {}", message);
    }
}