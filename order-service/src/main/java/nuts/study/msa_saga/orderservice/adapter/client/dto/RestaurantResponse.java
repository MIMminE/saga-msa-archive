package nuts.study.msa_saga.orderservice.adapter.client.dto;

public record RestaurantResponse(
        String orderId,
        boolean isApproved
) {
}
