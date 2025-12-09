package nuts.study.msa_saga.orderservice.infrastructure.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nuts.study.msa_saga.orderservice.application.provided.OrderService;
import nuts.study.msa_saga.orderservice.application.provided.dto.CancelOrderResponse;
import nuts.study.msa_saga.orderservice.application.provided.dto.CreateOrderRequest;
import nuts.study.msa_saga.orderservice.application.provided.dto.CreateOrderResponse;
import nuts.study.msa_saga.orderservice.application.provided.dto.GetOrderResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderApi {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<CreateOrderResponse> createOrder(@RequestBody CreateOrderRequest request) {
        log.info("Create order for customer: {} at restaurant: {}", request.customerId(), request.restaurantId());
        CreateOrderResponse response = orderService.createOrder(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/get/{orderId}")
    public ResponseEntity<GetOrderResponse> getOrder(@PathVariable String orderId) {
        log.info("Get order: {}", orderId);
        GetOrderResponse response = orderService.getOrder(orderId);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/cancel/{orderId}")
    // 인증된 사용자만 주문 취소 가능하도록 추후 수정 필요
    public ResponseEntity<CancelOrderResponse> cancelOrder(@PathVariable String orderId) {
        log.info("Cancel order: {}", orderId);
        CancelOrderResponse response = orderService.cancelOrder(orderId);
        return ResponseEntity.ok(response);
    }
}