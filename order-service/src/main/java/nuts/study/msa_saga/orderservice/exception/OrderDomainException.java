package nuts.study.msa_saga.orderservice.exception;

public class OrderDomainException extends RuntimeException {
    public OrderDomainException(String message) {
        super(message);
    }
}
