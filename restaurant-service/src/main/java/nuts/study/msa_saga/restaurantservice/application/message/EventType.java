package nuts.study.msa_saga.restaurantservice.application.message;

public enum EventType {
    ORDER_CREATED,
    ORDER_CANCELLED,
    ORDER_REJECTED,
    PAYMENT_APPROVED,
    PAYMENT_REJECTED,
    ORDER_CANCELLATION_FAILED,
    ORDER_CANCELLATION_COMPLETED
}