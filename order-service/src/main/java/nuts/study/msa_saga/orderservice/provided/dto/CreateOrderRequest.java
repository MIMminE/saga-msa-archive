package nuts.study.msa_saga.orderservice.provided.dto;

import java.util.UUID;

public record CreateOrderRequest(
        UUID customerId,
        UUID restaurantId

) {
}
