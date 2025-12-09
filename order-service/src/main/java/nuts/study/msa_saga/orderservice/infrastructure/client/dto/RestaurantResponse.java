package nuts.study.msa_saga.orderservice.infrastructure.client.dto;

public record RestaurantResponse(
        String orderId,
        boolean isApproved
) {
}
