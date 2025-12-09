package nuts.study.msa_saga.orderservice.application.required.repository;


import nuts.study.msa_saga.orderservice.domain.model.Order;
import org.springframework.data.repository.Repository;

import java.util.Optional;
import java.util.UUID;

public interface OrderRepository extends Repository<Order, UUID> {
    Order save(Order order);

    Optional<Order> findById(UUID id);
}
