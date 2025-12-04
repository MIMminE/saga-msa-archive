package nuts.study.msa_saga.orderservice.adapter.outbound.persistence.create;

import lombok.RequiredArgsConstructor;
import nuts.study.msa_saga.orderservice.application.port.persistence.OrderCreationOutboxPersistence;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderCreationOutboxPersistenceAdapter implements OrderCreationOutboxPersistence {

    private final OrderCreateOutboxJpaRepository orderCreateOutboxJpaRepository;

}
