package nuts.study.msa_saga.orderservice.domain;

import nuts.study.msa_saga.orderservice.domain.model.Order;
import nuts.study.msa_saga.orderservice.domain.event.OrderCancelledEvent;
import nuts.study.msa_saga.orderservice.domain.event.OrderCreatedEvent;
import nuts.study.msa_saga.orderservice.domain.event.OrderPaidEvent;
import nuts.study.msa_saga.orderservice.domain.vo.RestaurantId;

import java.util.List;

public interface OrderDomainService {

    OrderCreatedEvent validateAndInitiateOrder(Order order, RestaurantId restaurantId);

    OrderPaidEvent payOrder(Order order);

    void approveOrder(Order order);

    OrderCancelledEvent cancelOrderPayment(Order order, List<String> failureMessages);

    void cancelOrder(Order order, List<String> failureMessages);
}
