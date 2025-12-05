package nuts.study.msa_saga.orderservice.domain.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import nuts.study.msa_saga.orderservice.domain.vo.Money;

@RequiredArgsConstructor
@Getter
public class Product {
    private final String id;
    private final String name;
    private final Money price;
}
