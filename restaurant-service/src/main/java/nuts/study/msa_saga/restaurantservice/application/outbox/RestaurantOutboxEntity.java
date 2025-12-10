package nuts.study.msa_saga.restaurantservice.application.outbox;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import nuts.study.msa_saga.restaurantservice.application.message.EventType;

import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantOutboxEntity {

    @Id
    private UUID id;

    private UUID sagaId;

    private UUID orderId;

    @Enumerated(EnumType.STRING)
    private EventType eventType;

    @Enumerated(EnumType.STRING)
    private OutboxStatus outboxStatus;
}
