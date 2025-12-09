package nuts.study.msa_saga.orderservice.infrastructure.saga;

import lombok.RequiredArgsConstructor;
import nuts.study.msa_saga.orderservice.application.provided.SagaMessageProcessor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaSagaListener {

    private final SagaMessageProcessor sagaMessageProcessor;

    // 결제 승인 사가 메시지 수신 -> 주문 상태 변경(결제 완료) -> 주문 아웃박스 전송
    @KafkaListener
    public void listenPaymentApproved(String message) {
        sagaMessageProcessor.processPaymentApprovalEvent();
    }

    // 결제 거절 사가 메시지 수신 -> 주문 상태 변경(주문 취소) -> 주문 아웃박스 전송
    @KafkaListener
    public void listenPaymentRejected(String message) {
        sagaMessageProcessor.processPaymentRejectedEvent();
    }

    // 주문 취소 사가 메시지 수신 -> 주문 상태 변경(주문 취소 완료) -> 주문 아웃박스 전송
    @KafkaListener
    public void listenOrderCancelled(String message) {
        sagaMessageProcessor.processOrderCancelledEvent();
    }

}