package nuts.study.msa_saga.orderservice.infrastructure.saga;

import lombok.RequiredArgsConstructor;
import nuts.study.msa_saga.orderservice.application.provided.SagaPublishService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ScheduledSagePoller {

    private final SagaPublishService sagaPublishService;

    @Scheduled(fixedRate = 5000)
    public void tick() {
        sagaPublishService.publish();

    }
}
