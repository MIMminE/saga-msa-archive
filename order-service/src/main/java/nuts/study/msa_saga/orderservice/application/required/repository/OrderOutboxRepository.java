package nuts.study.msa_saga.orderservice.application.required.repository;

import nuts.study.msa_saga.orderservice.application.entity.OrderOutboxEntity;
import nuts.study.msa_saga.orderservice.application.entity.OutboxStatus;
import org.springframework.data.repository.Repository;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

public interface OrderOutboxRepository extends Repository<OrderOutboxEntity, UUID> {

    OrderOutboxEntity save(OrderOutboxEntity orderOutboxEntity);

    List<OrderOutboxEntity> findAllByOutboxStatusIn(Collection<OutboxStatus> outboxStatuses);
}
