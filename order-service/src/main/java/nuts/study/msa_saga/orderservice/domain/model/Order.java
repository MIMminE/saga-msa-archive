package nuts.study.msa_saga.orderservice.domain.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import nuts.study.msa_saga.orderservice.domain.OrderCreationSpec;
import nuts.study.msa_saga.orderservice.domain.vo.*;
import nuts.study.msa_saga.orderservice.domain.OrderDomainException;

import java.util.List;
import java.util.UUID;

@Getter
@Entity
@Table(name = "orders")
@NoArgsConstructor
public class Order {

    @Id
    private UUID orderId;

    private UUID customerId;

    private UUID restaurantId;

    @Embedded
    private StreetAddress streetAddress;

    @Embedded
    private Money price;

    private UUID trackingId;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    public static Order createOrder(OrderCreationSpec creationSpec) {
        return new Order(
                creationSpec.customerId(),
                creationSpec.restaurantId(),
                creationSpec.address(),
                new Money(creationSpec.price()),
                creationSpec.orderItems()
        );
    }

    public Order(UUID customerId, UUID restaurantId, StreetAddress streetAddress, Money price, List<OrderItem> orderItems) {
        this.orderId = UUID.randomUUID();
        this.customerId = customerId;
        this.restaurantId = restaurantId;
        this.streetAddress = streetAddress;
        this.price = price;
    }

    public void initializeOrder() {
        this.trackingId = UUID.randomUUID();
        this.orderStatus = OrderStatus.PENDING;
    }

    public void pay() {
        if (this.orderStatus != OrderStatus.PENDING) {
            throw new OrderDomainException("Order is not in correct state for pay operation!");
        }
        orderStatus = OrderStatus.PAID;
    }

    public void approve() {
        if (this.orderStatus != OrderStatus.PAID) {
            throw new OrderDomainException("Order is not in correct state for approve operation!");
        }
        this.orderStatus = OrderStatus.APPROVED;
    }

    public void initCancel(List<String> failureMessages) {
        if (orderStatus != OrderStatus.PAID) {
            throw new OrderDomainException("Order is not in correct state for initCancel operation!");
        }
        orderStatus = OrderStatus.CANCELLING;
    }

    public void cancel() {
        if (!(orderStatus == OrderStatus.CANCELLING || orderStatus == OrderStatus.PENDING)) {
            throw new OrderDomainException("Order is not in correct state for cancel operation!");
        }
        orderStatus = OrderStatus.CANCELLED;
    }
}