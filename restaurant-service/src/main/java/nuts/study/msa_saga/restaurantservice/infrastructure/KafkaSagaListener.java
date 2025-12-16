package nuts.study.msa_saga.restaurantservice.infrastructure;

import lombok.RequiredArgsConstructor;
import nuts.study.msa_saga.restaurantservice.application.message.OrderSagaMessage;
import nuts.study.msa_saga.restaurantservice.application.provided.RestaurantService;
import nuts.study.msa_saga.restaurantservice.application.provided.dto.OrderRequest;
import nuts.study.msa_saga.restaurantservice.application.provided.dto.OrderResult;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaSagaListener {

    private final RestaurantService restaurantService;


    public void listenOrderCreated(OrderSagaMessage sagaMessage) {
        OrderResult order = restaurantService.order(toOrderRequest(sagaMessage));
    }

    private OrderRequest toOrderRequest(OrderSagaMessage sagaMessage) {
        return new OrderRequest();
    }
}
