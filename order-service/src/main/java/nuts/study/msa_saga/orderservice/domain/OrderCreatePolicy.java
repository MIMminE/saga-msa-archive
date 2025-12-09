package nuts.study.msa_saga.orderservice.domain;

import lombok.extern.slf4j.Slf4j;
import nuts.study.msa_saga.orderservice.domain.model.Order;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class OrderCreatePolicy {

    public Order createOrder(OrderCreationSpec creationSpec) {
        log.info("Creating order");
        return Order.createOrder(creationSpec);
    }

    private void validateRestaurant(UUID restaurantId) {
        // TODO: Implement restaurant validation logic
    }

    private void setOrderProductInformation(Order order, UUID restaurantId) {
        // TODO: Implement logic to set product information in the order
    }
}
