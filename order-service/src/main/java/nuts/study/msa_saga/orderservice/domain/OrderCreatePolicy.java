package nuts.study.msa_saga.orderservice.domain;

import lombok.extern.slf4j.Slf4j;
import nuts.study.msa_saga.orderservice.domain.model.Order;
import nuts.study.msa_saga.orderservice.domain.vo.RestaurantId;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrderCreatePolicy {

    public Order createOrder(OrderCreationSpec creationSpec) {
        log.info("Creating order");

        return null;
    }

    private void validateRestaurant(RestaurantId restaurantId) {
        // TODO: Implement restaurant validation logic
    }

    private void setOrderProductInformation(Order order, RestaurantId restaurantId) {
        // TODO: Implement logic to set product information in the order
    }
}
