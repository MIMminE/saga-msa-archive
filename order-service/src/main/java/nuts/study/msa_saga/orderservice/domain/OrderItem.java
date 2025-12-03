package nuts.study.msa_saga.orderservice.domain;

import lombok.RequiredArgsConstructor;
import nuts.study.msa_saga.orderservice.vo.Money;
import nuts.study.msa_saga.orderservice.vo.OrderId;

@RequiredArgsConstructor
public class OrderItem {
    private final OrderId orderId;
    private final Product product;
    private final int quantity;
    private final Money price;
    private final Money subTotal;
}
