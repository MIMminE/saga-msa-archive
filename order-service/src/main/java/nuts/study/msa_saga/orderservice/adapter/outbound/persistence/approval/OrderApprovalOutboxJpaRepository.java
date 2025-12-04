package nuts.study.msa_saga.orderservice.adapter.outbound.persistence.approval;

import nuts.study.msa_saga.orderservice.application.outbox.model.OrderCreateOutboxEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

interface OrderApprovalOutboxJpaRepository extends JpaRepository<OrderCreateOutboxEntity, UUID> {
}
