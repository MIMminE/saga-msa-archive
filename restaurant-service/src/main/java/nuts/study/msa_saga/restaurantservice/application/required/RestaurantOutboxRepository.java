package nuts.study.msa_saga.restaurantservice.application.required;

import nuts.study.msa_saga.restaurantservice.application.outbox.RestaurantOutboxEntity;
import org.springframework.data.repository.Repository;

import java.util.UUID;

public interface RestaurantOutboxRepository extends Repository<RestaurantOutboxEntity, UUID> {
}
