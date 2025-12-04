package nuts.study.msa_saga.orderservice.infrastructure.scheduler;

import lombok.RequiredArgsConstructor;
import nuts.study.msa_saga.orderservice.application.outbox.message.OrderCreationOutboxMessage;
import nuts.study.msa_saga.orderservice.application.port.messaging.OutboxPublisher;
import nuts.study.msa_saga.orderservice.infrastructure.OutboxPollScheduler;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderCreationOutboxPollScheduler implements OutboxPollScheduler {

    private final OutboxPublisher<OrderCreationOutboxMessage> outboxPublisher;

    @Override
    public void processOutboxMessages() {

    }

}
