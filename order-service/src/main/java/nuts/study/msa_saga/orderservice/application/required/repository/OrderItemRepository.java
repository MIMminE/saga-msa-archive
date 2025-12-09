package nuts.study.msa_saga.orderservice.application.required.repository;

import nuts.study.msa_saga.orderservice.domain.model.OrderItem;
import org.springframework.data.repository.Repository;

import java.util.UUID;

public interface OrderItemRepository extends Repository<OrderItem, UUID> {
}
