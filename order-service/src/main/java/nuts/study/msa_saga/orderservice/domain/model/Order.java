package nuts.study.msa_saga.orderservice.domain.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
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

    @Embedded
    private CustomerId customerId;

    @Embedded
    private RestaurantId restaurantId;

    @Embedded
    private StreetAddress streetAddress;

    @Embedded
    private Money price;
    private List<OrderItem> orderItems;

    @Embedded
    private TrackingId trackingId;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
    private List<String> failureMessages;

    public Order(CustomerId customerId, RestaurantId restaurantId, StreetAddress streetAddress, Money price, List<OrderItem> orderItems) {
        this.orderId = UUID.randomUUID();
        this.customerId = customerId;
        this.restaurantId = restaurantId;
        this.streetAddress = streetAddress;
        this.price = price;
        this.orderItems = orderItems;
    }

    public void initializeOrder() {
        this.trackingId = new TrackingId(UUID.randomUUID());
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
        updateFailureMessages(failureMessages);
    }

    public void cancel(List<String> failureMessages) {
        if (!(orderStatus == OrderStatus.CANCELLING || orderStatus == OrderStatus.PENDING)) {
            throw new OrderDomainException("Order is not in correct state for cancel operation!");
        }
        orderStatus = OrderStatus.CANCELLED;
        updateFailureMessages(failureMessages);
    }

    private void updateFailureMessages(List<String> failureMessages) {
        if (this.failureMessages != null && failureMessages != null) {
            this.failureMessages.addAll(failureMessages.stream().filter(message -> !message.isEmpty()).toList());
        }
        if (this.failureMessages == null) {
            this.failureMessages = failureMessages;
        }
    }
}