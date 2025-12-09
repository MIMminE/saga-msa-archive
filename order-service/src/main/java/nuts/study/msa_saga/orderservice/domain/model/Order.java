package nuts.study.msa_saga.orderservice.domain.model;


import jakarta.persistence.*;
import lombok.*;
import nuts.study.msa_saga.orderservice.domain.vo.*;

import java.util.UUID;

@Getter
@Entity
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
@Builder(access = AccessLevel.PRIVATE)
public class Order {

    @Id
    private UUID orderId;

    private UUID customerId;

    private UUID restaurantId;

    private UUID trackingId;

    @Embedded
    private StreetAddress streetAddress;

    private Long totalPrice;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    public void cancel() {
        if (!(orderStatus == OrderStatus.PENDING)) {
            throw new IllegalArgumentException("Order is not in correct state for cancel operation!");
        }
        orderStatus = OrderStatus.CANCELLED;
    }
}