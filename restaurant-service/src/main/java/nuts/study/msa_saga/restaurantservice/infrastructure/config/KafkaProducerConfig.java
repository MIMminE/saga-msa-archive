package nuts.study.msa_saga.restaurantservice.infrastructure.config;

import nuts.study.msa_saga.restaurantservice.application.message.OrderSagaMessage;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {

    @Bean
    ProducerFactory<String, OrderSagaMessage> orderSagaMessageProducerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");

        // 신뢰성 설정
        props.put(ProducerConfig.ACKS_CONFIG, "all");             // ISR 모두 ack → 더 안전
        props.put(ProducerConfig.RETRIES_CONFIG, 10);             // 재시도
        props.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, true);// 멱등 프로듀서 → 중복 방지
        props.put(ProducerConfig.DELIVERY_TIMEOUT_MS_CONFIG, 120_000);

        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, OrderSagaMessageSerializer.class);

        return new DefaultKafkaProducerFactory<>(props);
    }

    @Bean
    public KafkaTemplate<String, OrderSagaMessage> orderSagaKafkaTemplate(ProducerFactory<String, OrderSagaMessage> pf) {
        return new KafkaTemplate<>(pf);
    }
}