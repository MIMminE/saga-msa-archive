package nuts.study.msa_saga.restaurantservice.application.required;

import nuts.study.msa_saga.restaurantservice.domain.model.Restaurant;
import org.springframework.data.repository.Repository;

import java.util.UUID;

public interface RestaurantRepository extends Repository<Restaurant, UUID> {
}

