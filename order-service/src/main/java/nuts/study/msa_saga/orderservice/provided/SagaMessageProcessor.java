package nuts.study.msa_saga.orderservice.provided;

import nuts.study.msa_saga.orderservice.provided.event.OrderCancelledEvent;
import nuts.study.msa_saga.orderservice.provided.event.OrderPaymentApprovalEvent;

public interface SagaMessageProcessor {

    void processPaymentApprovalEvent(OrderPaymentApprovalEvent orderPaymentApprovalEvent);

    void processPaymentRejectedEvent(OrderPaymentApprovalEvent orderPaymentApprovalEvent);

    void processOrderCancelledEvent(OrderCancelledEvent orderCancelledEvent);
}
