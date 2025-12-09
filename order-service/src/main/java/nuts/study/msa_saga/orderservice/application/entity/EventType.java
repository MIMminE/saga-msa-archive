package nuts.study.msa_saga.orderservice.application.entity;

public enum EventType {
    ORDER_CREATED,
    ORDER_CANCELLED,
    ORDER_REJECTED,
    PAYMENT_APPROVED,
    PAYMENT_REJECTED,
    ORDER_CANCELLATION_FAILED,
    ORDER_CANCELLATION_COMPLETED
}