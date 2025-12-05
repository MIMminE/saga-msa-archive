package nuts.study.msa_saga.orderservice.adapter.api;

import nuts.study.msa_saga.orderservice.domain.vo.OrderStatus;

import java.util.UUID;

public record CreateOrderResponse(
        UUID orderTrackingId,
        OrderStatus orderStatus,
        String message
) {
}
