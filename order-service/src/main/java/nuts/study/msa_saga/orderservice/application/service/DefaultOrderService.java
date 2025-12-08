package nuts.study.msa_saga.orderservice.application.service;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nuts.study.msa_saga.orderservice.application.entity.OrderOutboxEntity;
import nuts.study.msa_saga.orderservice.domain.OrderCreatePolicy;
import nuts.study.msa_saga.orderservice.domain.OrderCreationSpec;
import nuts.study.msa_saga.orderservice.domain.model.Order;
import nuts.study.msa_saga.orderservice.provided.OrderService;
import nuts.study.msa_saga.orderservice.provided.dto.CancelOrderResponse;
import nuts.study.msa_saga.orderservice.provided.dto.CreateOrderRequest;
import nuts.study.msa_saga.orderservice.provided.dto.CreateOrderResponse;
import nuts.study.msa_saga.orderservice.provided.dto.GetOrderResponse;
import nuts.study.msa_saga.orderservice.required.repository.OrderOutboxRepository;
import nuts.study.msa_saga.orderservice.required.repository.OrderRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class DefaultOrderService implements OrderService {

    private final OrderCreatePolicy orderCreatePolicy;
    private final OrderRepository orderRepository;
    private final OrderOutboxRepository orderOutboxRepository;

    @Override
    @Transactional
    public CreateOrderResponse createOrder(CreateOrderRequest request) {
        // 1. 주문 생성 정책에 따라 주문 생성
        Order order = orderCreatePolicy.createOrder(toOrderCreationSpec(request));
        Order savedOrder = orderRepository.save(order);

        // 2. 주문 생성 아웃박스 레코드 저장
        OrderOutboxEntity orderOutboxEntity = OrderOutboxEntity.create(savedOrder);
        orderOutboxRepository.save(orderOutboxEntity);

        return new CreateOrderResponse(order.getOrderId(), orderOutboxEntity.getTrackingId()
                , order.getRestaurantId(), order.getCustomerId(), order.getOrderStatus());
    }

    @Override
    public GetOrderResponse getOrder(String orderId) {

        return null;
    }

    @Override
    public CancelOrderResponse cancelOrder(String orderId) {

        return null;
    }

    private OrderCreationSpec toOrderCreationSpec(CreateOrderRequest createOrderRequest) {
        return null;
    }
}