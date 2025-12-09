package nuts.study.msa_saga.orderservice.domain;

import nuts.study.msa_saga.orderservice.domain.model.OrderItem;
import nuts.study.msa_saga.orderservice.domain.vo.StreetAddress;

import java.util.List;
import java.util.UUID;

public record CreateOrderRequest(
        UUID customerId,
        UUID restaurantId,
        Long price,
        List<OrderItem> orderItems,
        StreetAddress address
) {
}