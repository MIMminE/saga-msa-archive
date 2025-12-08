package nuts.study.msa_saga.orderservice.application.message;

import nuts.study.msa_saga.orderservice.application.entity.SagaType;

import java.util.UUID;

public record OrderSagaMessage(
        UUID sagaId,
        UUID trackingId,
        SagaType sagaType,
        String payload
) {
}
