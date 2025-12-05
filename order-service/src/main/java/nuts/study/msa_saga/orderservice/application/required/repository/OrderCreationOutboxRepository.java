package nuts.study.msa_saga.orderservice.application.required.repository;

import nuts.study.msa_saga.orderservice.application.entity.OrderCreationOutbox;
import org.springframework.data.repository.Repository;

import java.util.Optional;
import java.util.UUID;

public interface OrderCreationOutboxRepository extends Repository<OrderCreationOutbox, UUID> {
    OrderCreationOutbox save(OrderCreationOutbox orderCreationOutbox);

    Optional<OrderCreationOutbox> findById(UUID id);

    Optional<OrderCreationOutbox> findBySagaId(UUID sagaId);
}
