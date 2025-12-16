package saga_msa.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Map;

@Getter
@AllArgsConstructor
public class OrderSagaEvent {

    Long sagaId;
    SageEventType type;
    LocalDateTime createdAt;
    Map<String, Object> payload;
}