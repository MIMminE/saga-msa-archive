package nuts.study.msa_saga.orderservice.application.service;

import nuts.study.msa_saga.orderservice.provided.SagaMessageProcessor;
import nuts.study.msa_saga.orderservice.provided.event.OrderCancelledEvent;
import nuts.study.msa_saga.orderservice.provided.event.OrderPaymentApprovalEvent;
import org.springframework.stereotype.Component;

@Component
public class DefaultSagaMessageProcessor implements SagaMessageProcessor {

    @Override
    public void processPaymentApprovalEvent(OrderPaymentApprovalEvent orderPaymentApprovalEvent) {

    }

    @Override
    public void processPaymentRejectedEvent(OrderPaymentApprovalEvent orderPaymentApprovalEvent) {

    }

    @Override
    public void processOrderCancelledEvent(OrderCancelledEvent orderCancelledEvent) {

    }

}
