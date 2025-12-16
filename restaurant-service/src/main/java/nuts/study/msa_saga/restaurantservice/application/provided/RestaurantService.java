package nuts.study.msa_saga.restaurantservice.application.provided;

import nuts.study.msa_saga.restaurantservice.application.provided.dto.OrderRequest;
import nuts.study.msa_saga.restaurantservice.application.provided.dto.OrderResult;

public interface RestaurantService {

    OrderResult order(OrderRequest orderRequest);
}