package nuts.study.msa_saga.orderservice.adapter.saga;

import lombok.RequiredArgsConstructor;
import nuts.study.msa_saga.orderservice.provided.SagaPublishService;
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
