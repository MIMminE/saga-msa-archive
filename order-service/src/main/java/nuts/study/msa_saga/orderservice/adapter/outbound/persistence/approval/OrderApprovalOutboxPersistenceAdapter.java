package nuts.study.msa_saga.orderservice.adapter.outbound.persistence.approval;

import lombok.RequiredArgsConstructor;
import nuts.study.msa_saga.orderservice.application.port.persistence.OrderApprovalOutboxPersistence;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class OrderApprovalOutboxPersistenceAdapter implements OrderApprovalOutboxPersistence {
    private final OrderApprovalOutboxJpaRepository orderApprovalOutboxJpaRepository;
}
