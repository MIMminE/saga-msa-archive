package nuts.study.msa_saga.orderservice;

import nuts.study.msa_saga.orderservice.domain.Order;
import nuts.study.msa_saga.orderservice.event.OrderCancelledEvent;
import nuts.study.msa_saga.orderservice.event.OrderCreatedEvent;
import nuts.study.msa_saga.orderservice.event.OrderPaidEvent;
import nuts.study.msa_saga.orderservice.vo.RestaurantId;

import java.util.List;

public interface OrderDomainService {

    OrderCreatedEvent validateAndInitiateOrder(Order order, RestaurantId restaurantId);

    OrderPaidEvent payOrder(Order order);

    void approveOrder(Order order);

    OrderCancelledEvent cancelOrderPayment(Order order, List<String> failureMessages);

    void cancelOrder(Order order, List<String> failureMessages);
}
