package nuts.study.msa_saga.orderservice.application.provided;

import nuts.study.msa_saga.orderservice.domain.OrderCreateRequest;
import nuts.study.msa_saga.orderservice.domain.model.Order;

public interface OrderManager {
    Order createOrder(OrderCreateRequest request);

    Order getOrder(String orderId);

    Order cancelOrder(String orderId);
}
