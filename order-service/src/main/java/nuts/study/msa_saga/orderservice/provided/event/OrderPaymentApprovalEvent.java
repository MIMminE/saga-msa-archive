package nuts.study.msa_saga.orderservice.provided.event;

import nuts.study.msa_saga.orderservice.domain.model.Order;

import java.time.ZonedDateTime;

public class OrderPaymentApprovalEvent extends OrderEvent {
    public OrderPaymentApprovalEvent(Order order, ZonedDateTime createdAt) {
        super(order, createdAt);
    }
}
