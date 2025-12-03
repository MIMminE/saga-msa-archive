package nuts.study.msa_saga.orderservice.domain.event;

import nuts.study.msa_saga.orderservice.domain.model.Order;

import java.time.ZonedDateTime;

public class OrderPaidEvent extends OrderEvent {
    public OrderPaidEvent(Order order, ZonedDateTime createdAt) {
        super(order, createdAt);
    }
}
