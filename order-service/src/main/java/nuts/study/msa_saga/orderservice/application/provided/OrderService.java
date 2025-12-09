package nuts.study.msa_saga.orderservice.application.provided;

import nuts.study.msa_saga.orderservice.application.provided.dto.CancelOrderResponse;
import nuts.study.msa_saga.orderservice.domain.CreateOrderRequest;
import nuts.study.msa_saga.orderservice.application.provided.dto.CreateOrderResponse;
import nuts.study.msa_saga.orderservice.application.provided.dto.GetOrderResponse;

import java.util.UUID;

public interface OrderService {

    CreateOrderResponse createOrder(CreateOrderRequest request);

    GetOrderResponse getOrder(UUID orderId);

    CancelOrderResponse cancelOrder(UUID orderId);
}