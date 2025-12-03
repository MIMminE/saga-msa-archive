package nuts.study.msa_saga.orderservice.domain;

public class OrderDomainException extends RuntimeException {
    public OrderDomainException(String message) {
        super(message);
    }
}
