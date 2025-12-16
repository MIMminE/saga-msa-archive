package nuts.study.msa_saga.restaurantservice.application.provided.dto;

public record OrderResult(
        String orderId,
        boolean accepted
) {
}
