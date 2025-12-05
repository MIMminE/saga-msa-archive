package nuts.study.msa_saga.orderservice.adapter.outbox;

import lombok.RequiredArgsConstructor;
import nuts.study.msa_saga.orderservice.application.required.outbox.OutboxRecordPoller;
import nuts.study.msa_saga.orderservice.application.service.OutboxMessagePublishService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ScheduledOutboxRecordPoller implements OutboxRecordPoller {

    private final OutboxMessagePublishService outboxMessagePublishService;

    @Override
    @Scheduled(fixedDelay = 10_000)
    public void pollOutboxRecords() {
        outboxMessagePublishService.publishApprovalOutboxMessages();
    }
}