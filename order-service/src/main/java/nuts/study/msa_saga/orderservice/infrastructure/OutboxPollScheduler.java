package nuts.study.msa_saga.orderservice.infrastructure;

public interface OutboxPollScheduler {
    void processOutboxMessages();
}
