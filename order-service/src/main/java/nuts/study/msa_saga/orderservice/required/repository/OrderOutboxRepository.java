package nuts.study.msa_saga.orderservice.required.repository;

import nuts.study.msa_saga.orderservice.application.entity.OrderOutboxEntity;
import org.springframework.data.repository.Repository;

import java.util.UUID;

public interface OrderOutboxRepository extends Repository<OrderOutboxEntity, UUID> {

    OrderOutboxEntity save(OrderOutboxEntity orderOutboxEntity);
}
