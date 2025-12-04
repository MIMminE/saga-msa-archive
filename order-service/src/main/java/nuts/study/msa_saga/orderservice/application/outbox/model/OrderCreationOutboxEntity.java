package nuts.study.msa_saga.orderservice.application.outbox.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

import java.util.UUID;

@Entity
@Table(name = "order_creation_outbox")
@Getter
public class OrderCreationOutboxEntity {

    @Id
    private UUID id;
    private UUID sageId;
    private String payload;
    private String outboxStatus;
}