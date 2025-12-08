package nuts.study.msa_saga.orderservice.provided.event;

import lombok.RequiredArgsConstructor;
import nuts.study.msa_saga.orderservice.domain.model.Order;

import java.time.ZonedDateTime;

@RequiredArgsConstructor
public abstract class OrderEvent {
    private final Order order;
    private final ZonedDateTime createdAt;
}
