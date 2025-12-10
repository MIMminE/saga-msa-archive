package nuts.study.msa_saga.restaurantservice.application.required;

import nuts.study.msa_saga.restaurantservice.domain.model.ProductInventory;
import org.springframework.data.repository.Repository;

public interface ProductInventoryRepository extends Repository<ProductInventory, Long> {
}
