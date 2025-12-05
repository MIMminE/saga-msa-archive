package nuts.study.msa_saga.orderservice.adapter.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nuts.study.msa_saga.orderservice.application.service.OrderService;
import nuts.study.msa_saga.orderservice.domain.OrderCreateRequest;
import nuts.study.msa_saga.orderservice.domain.model.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderApi {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<CreateOrderResponse> createOrder(@RequestBody OrderCreateRequest request) {
        log.info("Create order for customer: {} at restaurant: {}", request.customerId(), request.restaurantId());
        CreateOrderResponse createOrderResponse = toCreateOrderResponse(orderService.createOrder(request));
        return ResponseEntity.ok(createOrderResponse);
    }

    private CreateOrderResponse toCreateOrderResponse(Order order) {
        return new CreateOrderResponse(order.getTrackingId().id(), order.getOrderStatus(), "Order created successfully");
    }
}