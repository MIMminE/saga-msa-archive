package nuts.study.msa_saga.orderservice.adapter.outbound.persistence.order;

import lombok.RequiredArgsConstructor;
import nuts.study.msa_saga.orderservice.application.port.persistence.OrderPersistence;
import nuts.study.msa_saga.orderservice.domain.model.Order;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderPersistenceAdapter implements OrderPersistence {

    private final OrderJpaRepository jpaRepository;

    @Override
    public Order save(Order order) {
        return jpaRepository.save(order);
    }
}