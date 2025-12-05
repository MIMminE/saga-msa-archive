package nuts.study.msa_saga.orderservice.application.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

import java.util.UUID;

@Entity
@Getter
public class OrderApprovalOutbox implements OutboxRecord{
    @Id
    private UUID id;
    private UUID sageId;
    private String payload;
    private String outboxStatus;
}
