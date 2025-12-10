package nuts.study.msa_saga.orderservice.domain;

import nuts.study.msa_saga.orderservice.domain.vo.StreetAddress;

import java.util.Map;
import java.util.UUID;

public record CreateOrderRequest(
        UUID customerId,
        UUID restaurantId,
        Map<String, Integer> products,
        StreetAddress address
) {
}