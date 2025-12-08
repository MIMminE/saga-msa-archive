package nuts.study.msa_saga.orderservice.provided;

import nuts.study.msa_saga.orderservice.provided.dto.CancelOrderResponse;
import nuts.study.msa_saga.orderservice.provided.dto.CreateOrderRequest;
import nuts.study.msa_saga.orderservice.provided.dto.CreateOrderResponse;
import nuts.study.msa_saga.orderservice.provided.dto.GetOrderResponse;

public interface OrderService {

    CreateOrderResponse createOrder(CreateOrderRequest request);

    GetOrderResponse getOrder(String orderId);

    CancelOrderResponse cancelOrder(String orderId);
}