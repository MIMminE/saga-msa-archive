package nuts.study.msa_saga.orderservice.event;

import nuts.study.msa_saga.orderservice.domain.Order;

import java.time.ZonedDateTime;

public class OrderCancelledEvent extends OrderEvent{
    public OrderCancelledEvent(Order order, ZonedDateTime createdAt) {
        super(order, createdAt);
    }
}
