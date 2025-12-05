package nuts.study.msa_saga.orderservice.application.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import nuts.study.msa_saga.orderservice.application.message.OrderApprovalOutboxMessage;
import nuts.study.msa_saga.orderservice.application.message.OrderCreationOutboxMessage;
import nuts.study.msa_saga.orderservice.application.required.outbox.OutboxMessagePublisher;
import nuts.study.msa_saga.orderservice.application.required.repository.OrderApprovalOutboxRepository;
import nuts.study.msa_saga.orderservice.application.required.repository.OrderCreationOutboxRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OutboxMessagePublishService {

    private final OrderApprovalOutboxRepository orderApprovalOutboxRepository;
    private final OrderCreationOutboxRepository orderCreationOutboxRepository;
    private final OutboxMessagePublisher<OrderApprovalOutboxMessage> approvalMessagePublisher;
    private final OutboxMessagePublisher<OrderCreationOutboxMessage> creationMessagePublisher;

    @Scheduled(fixedDelay = 5_000)
    @Transactional
    public void publishApprovalOutboxMessages() {

    }
}
