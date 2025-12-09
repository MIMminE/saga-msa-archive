package nuts.study.msa_saga.orderservice.application.provided.dto;

import nuts.study.msa_saga.orderservice.domain.vo.CustomerId;
import nuts.study.msa_saga.orderservice.domain.vo.OrderStatus;
import nuts.study.msa_saga.orderservice.domain.vo.RestaurantId;

import java.util.UUID;

public record CreateOrderResponse(
        UUID orderId,
        UUID orderTrackingId,
        RestaurantId restaurantId,
        CustomerId customerId,
        OrderStatus orderStatus
) {
}
