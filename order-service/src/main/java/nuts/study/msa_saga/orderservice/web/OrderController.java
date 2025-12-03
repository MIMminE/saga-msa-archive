package nuts.study.msa_saga.orderservice.web;

import lombok.extern.slf4j.Slf4j;
import nuts.study.msa_saga.orderservice.web.dto.CreateOrderRequest;
import nuts.study.msa_saga.orderservice.web.dto.CreateOrderResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/orders")
public class OrderController {

    @PostMapping
    public ResponseEntity<CreateOrderResponse> createOrder(@RequestBody CreateOrderRequest createOrderRequest) {
        log.info("Create order for customer: {} at restaurant: {}", createOrderRequest.customerId(), createOrderRequest.restaurantId());


        return ResponseEntity.ok(new CreateOrderResponse());
    }
}
