package nuts.study.msa_saga.orderservice.domain.vo;

public record StreetAddress(
        String street,
        String postalCode,
        String city
) {
}
