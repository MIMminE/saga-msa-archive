package nuts.study.msa_saga.orderservice.domain;

import nuts.study.msa_saga.orderservice.domain.model.OrderItem;
import nuts.study.msa_saga.orderservice.domain.vo.StreetAddress;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public record OrderCreationSpec(
        UUID customerId,
        UUID restaurantId,
        BigDecimal price,
        List<OrderItem> orderItems,
        StreetAddress address
) {
}
