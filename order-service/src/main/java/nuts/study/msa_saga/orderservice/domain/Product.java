package nuts.study.msa_saga.orderservice.domain;

import lombok.RequiredArgsConstructor;
import nuts.study.msa_saga.orderservice.vo.Money;

@RequiredArgsConstructor
public class Product {
    private final String name;
    private final Money price;
}
