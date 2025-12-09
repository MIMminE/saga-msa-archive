package nuts.study.msa_saga.orderservice.domain.model;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import nuts.study.msa_saga.orderservice.domain.vo.Money;

@RequiredArgsConstructor
@Getter
@Embeddable
public class Product {
    private String name;
    private Money price;
}
