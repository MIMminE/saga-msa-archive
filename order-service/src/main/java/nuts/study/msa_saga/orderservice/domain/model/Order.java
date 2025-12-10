package nuts.study.msa_saga.orderservice.domain.model;


import jakarta.persistence.*;
import lombok.*;
import nuts.study.msa_saga.orderservice.domain.CreateOrderRequest;
import nuts.study.msa_saga.orderservice.domain.vo.*;

import java.util.ArrayList;
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

    private UUID trackingId;

    @Embedded
    private StreetAddress streetAddress;

    private Long totalPrice;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<OrderItem> orderItems = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    public static Order createOrder(CreateOrderRequest createOrderRequest) {
        Order order = new Order();
        order.orderId = UUID.randomUUID();
        order.customerId = createOrderRequest.customerId();
        order.restaurantId = createOrderRequest.restaurantId();
        order.trackingId = UUID.randomUUID();
        order.streetAddress = createOrderRequest.address();
//        order.totalPrice = createOrderRequest.price();
        order.orderStatus = OrderStatus.PENDING;

        return order;
    }

    public void addOrderItem(OrderItem orderItem) {
        this.orderItems.add(orderItem);
        orderItem.assignOrder(this);
    }

    public void cancel() {
        if (!(orderStatus == OrderStatus.PENDING)) {
            throw new IllegalArgumentException("Order is not in correct state for cancel operation!");
        }
        orderStatus = OrderStatus.CANCELLED;
    }
}