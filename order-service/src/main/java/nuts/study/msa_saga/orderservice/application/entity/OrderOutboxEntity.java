package nuts.study.msa_saga.orderservice.application.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import nuts.study.msa_saga.orderservice.domain.model.Order;
import nuts.study.msa_saga.orderservice.domain.vo.OrderStatus;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderOutboxEntity {

    @Id
    private UUID id;
    private UUID sagaId;
    private UUID trackingId;
    private String payload;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @Enumerated(EnumType.STRING)
    private OutboxStatus outboxStatus;

    private LocalDateTime createdAt;

    public static OrderOutboxEntity create(Order order) {
        OrderOutboxEntity entity = new OrderOutboxEntity();
        entity.id = UUID.randomUUID();
        entity.sagaId = UUID.randomUUID();
        entity.trackingId = order.getTrackingId();
        entity.payload = ""; // Serialize order details as needed
        entity.orderStatus = order.getOrderStatus();
        entity.createdAt = LocalDateTime.now();
        return entity;
    }

    public void complete() {
        this.outboxStatus = OutboxStatus.SENT;
    }

    public void fail() {
        this.outboxStatus = OutboxStatus.FAILED;
    }
}