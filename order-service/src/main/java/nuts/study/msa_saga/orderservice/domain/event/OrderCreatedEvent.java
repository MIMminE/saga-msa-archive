package nuts.study.msa_saga.orderservice.domain.event;

import nuts.study.msa_saga.orderservice.domain.model.Order;

import java.time.ZonedDateTime;

public class OrderCreatedEvent extends OrderEvent {
    public OrderCreatedEvent(Order order, ZonedDateTime createdAt) {
        super(order, createdAt);
    }
}
