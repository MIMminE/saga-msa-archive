package nuts.study.msa_saga.orderservice.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@Entity
public class Product {
    @Id
    private String productId;
    private String name;
    private Long price;
}