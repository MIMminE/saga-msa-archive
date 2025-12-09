package nuts.study.msa_saga.orderservice.application.provided;

import nuts.study.msa_saga.orderservice.application.message.OrderSagaMessage;

public interface SagaEventProcessor {

    void processEvent(OrderSagaMessage orderSagaMessage);
}
