package nuts.study.msa_saga.orderservice.vo;

import java.util.UUID;

public record StreetAddress(
        UUID id,
        String street,
        String postalCode,
        String city
) {
}
