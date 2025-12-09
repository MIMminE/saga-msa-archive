package nuts.study.msa_saga.orderservice.application.service;

import lombok.extern.slf4j.Slf4j;
import nuts.study.msa_saga.orderservice.application.entity.EventType;
import nuts.study.msa_saga.orderservice.application.message.OrderSagaMessage;
import nuts.study.msa_saga.orderservice.application.provided.SagaEventProcessor;
import nuts.study.msa_saga.orderservice.application.service.processor.*;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class DelegateSagaEventProcessor implements SagaEventProcessor {

    private final Map<EventType, SagaEventProcessor> processorMap;

    public DelegateSagaEventProcessor() {
        this.processorMap = new HashMap<>();
        this.processorMap.put(EventType.ORDER_REJECTED, new OrderRejectEventProcessor());
        this.processorMap.put(EventType.ORDER_CANCELLATION_COMPLETED, new OrderCancellationSuccessEventProcessor());
        this.processorMap.put(EventType.ORDER_CANCELLATION_FAILED, new OrderCancellationFailEventProcessor());
        this.processorMap.put(EventType.PAYMENT_APPROVED, new PaymentApprovalEventProcessor());
        this.processorMap.put(EventType.PAYMENT_REJECTED, new PaymentRejectedEventProcessor());
    }

    @Override
    public void processEvent(OrderSagaMessage orderSagaMessage) {
        EventType eventType = orderSagaMessage.eventType();
        SagaEventProcessor sagaEventProcessor = processorMap.get(eventType);
        if (sagaEventProcessor != null) {
            sagaEventProcessor.processEvent(orderSagaMessage);
        } else {
            log.error("No processor found for event type: {}", eventType);
            throw new IllegalStateException("No processor registered for eventType: " + eventType);
        }
    }
}
