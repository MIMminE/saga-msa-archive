package nuts.study.msa_saga.orderservice.application.entity;

public enum OutboxStatus {
    PENDING,        // 생성됨, 아직 발행 전
    PUBLISHING,     // 발행 중(선택)
    SENT,           // 발행 완료
    FAILED,         // 발행 실패(재시도 대상)
    RETRYING,       // 재시도 진행/대기
    DEAD_LETTER     // 재시도 한계 초과
}