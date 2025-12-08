package nuts.study.msa_saga.orderservice.application.service;

import lombok.RequiredArgsConstructor;
import nuts.study.msa_saga.orderservice.adapter.saga.KafkaSagaPublisher;
import nuts.study.msa_saga.orderservice.provided.SagaPublishService;
import nuts.study.msa_saga.orderservice.required.repository.OrderOutboxRepository;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class DefaultSagaPublishService implements SagaPublishService {

    private final KafkaSagaPublisher kafkaSagaPublisher;
    private final OrderOutboxRepository orderOutboxRepository;

    @Override
    public void publish() {

    }
}
