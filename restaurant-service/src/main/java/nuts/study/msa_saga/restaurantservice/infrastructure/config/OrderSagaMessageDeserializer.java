package nuts.study.msa_saga.restaurantservice.infrastructure.config;

import nuts.study.msa_saga.restaurantservice.application.message.OrderSagaMessage;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.UUID;

/**
 * Simple JSON deserializer for OrderSagaMessage.
 * Expects JSON fields: sagaId, trackingId, eventType, payload
 */
public class OrderSagaMessageDeserializer implements Deserializer<OrderSagaMessage> {

    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        // no-op
    }

    @Override
    public OrderSagaMessage deserialize(String topic, byte[] data) {
        if (data == null) return null;
        try {
            String json = new String(data, StandardCharsets.UTF_8);
            JsonNode node = mapper.readTree(json);
            UUID sagaId = node.hasNonNull("sagaId") ? UUID.fromString(node.get("sagaId").asText()) : null;
            UUID trackingId = node.hasNonNull("trackingId") ? UUID.fromString(node.get("trackingId").asText()) : null;
            EventType eventType = node.hasNonNull("eventType") ? EventType.valueOf(node.get("eventType").asText()) : null;
            String payload = node.hasNonNull("payload") ? node.get("payload").asText() : null;
            return new OrderSagaMessage(sagaId, trackingId, eventType, payload);
        } catch (Exception e) {
            throw new SerializationException("Error deserializing OrderSagaMessage", e);
        }
    }

    @Override
    public void close() {
        // no-op
    }
}

