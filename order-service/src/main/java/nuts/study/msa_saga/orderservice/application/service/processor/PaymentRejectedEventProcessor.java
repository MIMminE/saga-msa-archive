package nuts.study.msa_saga.orderservice.application.service.processor;


import nuts.study.msa_saga.orderservice.application.message.OrderSagaMessage;
import nuts.study.msa_saga.orderservice.application.provided.SagaEventProcessor;

public class PaymentRejectedEventProcessor implements SagaEventProcessor {

    @Override
    public void processEvent(OrderSagaMessage orderSagaMessage) {

    }
}
