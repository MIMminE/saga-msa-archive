package nuts.study.msa_saga.orderservice.domain;

import lombok.extern.slf4j.Slf4j;
import nuts.study.msa_saga.orderservice.domain.model.Order;
import nuts.study.msa_saga.orderservice.domain.event.OrderCancelledEvent;
import nuts.study.msa_saga.orderservice.domain.event.OrderCreatedEvent;
import nuts.study.msa_saga.orderservice.domain.event.OrderPaidEvent;
import nuts.study.msa_saga.orderservice.domain.vo.RestaurantId;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

@Slf4j
@Service
public class DefaultOrderDomainService implements OrderDomainService {

    // 레파지토리, 퍼시스턴트에 대한 의존성 없이 도메인 로직만 구현

    @Override
    public OrderCreatedEvent validateAndInitiateOrder(Order order, RestaurantId restaurantId) {
        order.initializeOrder();
        log.info("Order with id {} is initialized", order.getOrderId());
        return new OrderCreatedEvent(order, ZonedDateTime.now(ZoneId.of("UTC")));
    }

    @Override
    public OrderPaidEvent payOrder(Order order) {
        order.pay();
        log.info("Order with id {} is paid", order.getOrderId());
        return new OrderPaidEvent(order, ZonedDateTime.now(ZoneId.of("UTC")));
    }

    @Override
    public void approveOrder(Order order) {
        order.approve();
        log.info("Order with id {} is approved", order.getOrderId());
    }

    @Override
    public OrderCancelledEvent cancelOrderPayment(Order order, List<String> failureMessages) {
        order.initCancel(failureMessages);
        log.info("Order payment is cancelling for order id: {}", order.getOrderId());
        return new OrderCancelledEvent(order, ZonedDateTime.now(ZoneId.of("UTC")));
    }

    @Override
    public void cancelOrder(Order order, List<String> failureMessages) {
        order.cancel(failureMessages);
        log.info("Order with id: {} is cancelled", order.getOrderId());
    }

    private void validateRestaurant(RestaurantId restaurantId) {
        // TODO: Implement restaurant validation logic
    }

    private void setOrderProductInformation(Order order, RestaurantId restaurantId) {
        // TODO: Implement logic to set product information in the order
    }   
}