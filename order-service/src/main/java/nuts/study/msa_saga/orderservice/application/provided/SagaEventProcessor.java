package nuts.study.msa_saga.orderservice.application.provided;


import saga_msa.common.OrderSagaEvent;

public interface SagaEventProcessor {

    void processEvent(OrderSagaEvent orderSagaMessage);
}
