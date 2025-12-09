package nuts.study.msa_saga.orderservice.application.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nuts.study.msa_saga.orderservice.application.entity.OrderOutboxEntity;
import nuts.study.msa_saga.orderservice.application.entity.OutboxStatus;
import nuts.study.msa_saga.orderservice.application.message.OrderSagaMessage;
import nuts.study.msa_saga.orderservice.application.required.saga.SagaMessagePublisher;
import nuts.study.msa_saga.orderservice.application.provided.SagaPublishService;
import nuts.study.msa_saga.orderservice.application.required.repository.OrderOutboxRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class DefaultSagaPublishService implements SagaPublishService {

    private final SagaMessagePublisher sagaMessagePublisher;
    private final OrderOutboxRepository orderOutboxRepository;

    @Override
    @Transactional
    public void publish() {
        List<OrderOutboxEntity> outboxes = orderOutboxRepository
                .findAllByOutboxStatusIn(List.of(OutboxStatus.PENDING, OutboxStatus.FAILED));

        for (OrderOutboxEntity outboxEntity : outboxes) {
            try {
                OrderSagaMessage sagaMessage = toSageMessage(outboxEntity);
                sagaMessagePublisher.publish(sagaMessage);
                outboxEntity.complete();
            } catch (Exception e) {
                outboxEntity.fail();
                log.error(e.getMessage());
            }
        }
    }

    private OrderSagaMessage toSageMessage(OrderOutboxEntity outboxEntity) {
        return new OrderSagaMessage(outboxEntity.getSagaId(), outboxEntity.getTrackingId(),
                outboxEntity.getEventType(), outboxEntity.getPayload());
    }
}