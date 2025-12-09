package nuts.study.msa_saga.orderservice.domain;

import nuts.study.msa_saga.orderservice.domain.model.Order;

import java.util.Map;
import java.util.UUID;

public record OrderAggregate(
        Order order,
        Map<UUID, Integer> productQuantityMap
) {
}