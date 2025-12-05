package nuts.study.msa_saga.orderservice.application.required.outbox;

/**
 * Outbox Record 를 폴링하는 기능을 제공하는 인터페이스
 */
public interface OutboxRecordPoller {
    void pollOutboxRecords();
}
