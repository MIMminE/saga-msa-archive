package nuts.study.msa_saga.orderservice.domain;

import lombok.extern.slf4j.Slf4j;
import nuts.study.msa_saga.orderservice.domain.model.Order;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class OrderCreatePolicy {

    public OrderAggregate createOrder(CreateOrderRequest createOrderRequest) {
        log.info("Creating order");
    }
}
