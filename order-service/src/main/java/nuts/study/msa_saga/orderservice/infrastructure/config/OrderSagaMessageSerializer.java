package nuts.study.msa_saga.orderservice.infrastructure.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import nuts.study.msa_saga.orderservice.application.message.OrderSagaMessage;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

/**
 * Kafka Serializer for OrderSagaMessage. Serializes the record to JSON bytes.
 */
public class OrderSagaMessageSerializer implements Serializer<OrderSagaMessage> {

    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        // nothing to configure
    }

    @Override
    public byte[] serialize(String topic, OrderSagaMessage data) {
        if (data == null) {
            return null;
        }
        try {
            ObjectNode root = mapper.createObjectNode();
            if (data.sagaId() != null) root.put("sagaId", data.sagaId().toString());
            if (data.trackingId() != null) root.put("trackingId", data.trackingId().toString());
            if (data.eventType() != null) root.put("eventType", data.eventType().name());
            if (data.payload() != null) root.put("payload", data.payload());
            return mapper.writeValueAsBytes(root);
        } catch (Exception e) {
            throw new SerializationException("Error serializing OrderSagaMessage", e);
        }
    }

    @Override
    public void close() {
        // no-op
    }
}

