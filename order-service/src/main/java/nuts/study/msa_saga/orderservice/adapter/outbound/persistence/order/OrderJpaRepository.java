package nuts.study.msa_saga.orderservice.adapter.outbound.persistence.order;

import nuts.study.msa_saga.orderservice.domain.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

interface OrderJpaRepository extends JpaRepository<Order, Long> {
}
