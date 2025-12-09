package nuts.study.msa_saga.orderservice.application.message;

import nuts.study.msa_saga.orderservice.application.entity.EventType;

import java.util.UUID;

public record OrderSagaMessage(
        UUID sagaId,
        UUID trackingId,
        EventType eventType,
        String payload
) {
}