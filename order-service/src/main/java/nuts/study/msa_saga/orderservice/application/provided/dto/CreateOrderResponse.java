package nuts.study.msa_saga.orderservice.application.provided.dto;

import nuts.study.msa_saga.orderservice.domain.vo.OrderStatus;

import java.util.UUID;

public record CreateOrderResponse(
        UUID orderId,
        UUID orderTrackingId,
        UUID restaurantId,
        UUID customerId,
        OrderStatus orderStatus
) {
}
