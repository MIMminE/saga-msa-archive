package nuts.study.msa_saga.orderservice.application.required.repository;

import nuts.study.msa_saga.orderservice.application.entity.OrderApprovalOutbox;
import org.springframework.data.repository.Repository;

import java.util.Optional;
import java.util.UUID;

public interface OrderApprovalOutboxRepository extends Repository<OrderApprovalOutbox, UUID> {
    OrderApprovalOutbox save(OrderApprovalOutbox orderApprovalOutbox);

    Optional<OrderApprovalOutbox> findById(UUID id);

    Optional<OrderApprovalOutbox> findBySagaId(UUID sagaId);
}
