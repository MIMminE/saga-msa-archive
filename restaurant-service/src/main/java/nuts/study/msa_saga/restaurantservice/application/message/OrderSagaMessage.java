package nuts.study.msa_saga.restaurantservice.application.message;

import java.util.UUID;

public record OrderSagaMessage(
        UUID sagaId,
        UUID trackingId,
        EventType eventType,
        String payload
) {
}
