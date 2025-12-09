package nuts.study.msa_saga.orderservice.application.service;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nuts.study.msa_saga.orderservice.application.entity.EventType;
import nuts.study.msa_saga.orderservice.application.entity.OrderOutboxEntity;
import nuts.study.msa_saga.orderservice.domain.OrderCreatePolicy;
import nuts.study.msa_saga.orderservice.domain.OrderCreationSpec;
import nuts.study.msa_saga.orderservice.domain.model.Order;
import nuts.study.msa_saga.orderservice.application.provided.OrderService;
import nuts.study.msa_saga.orderservice.application.provided.dto.CancelOrderResponse;
import nuts.study.msa_saga.orderservice.application.provided.dto.CreateOrderRequest;
import nuts.study.msa_saga.orderservice.application.provided.dto.CreateOrderResponse;
import nuts.study.msa_saga.orderservice.application.provided.dto.GetOrderResponse;
import nuts.study.msa_saga.orderservice.application.required.repository.OrderOutboxRepository;
import nuts.study.msa_saga.orderservice.application.required.repository.OrderRepository;
import nuts.study.msa_saga.orderservice.domain.model.OrderItem;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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
        // 1. 주문 생성 정책에 따라 주문 생성 및 저장
        Order order = orderCreatePolicy.createOrder(toOrderCreationSpec(request));
        Order savedOrder = orderRepository.save(order);

        // 2. 주문 생성 아웃박스 레코드 저장
        OrderOutboxEntity createOrderOutbox = persistOrderOutbox(order, EventType.ORDER_CREATED);

        return new CreateOrderResponse(order.getOrderId(), createOrderOutbox.getTrackingId()
                , order.getRestaurantId(), order.getCustomerId(), order.getOrderStatus());
    }

    @Override
    public GetOrderResponse getOrder(UUID orderId) {

        return null;
    }

    @Override
    @Transactional
    public CancelOrderResponse cancelOrder(UUID orderId) {

        Order order = orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Order not found: " + orderId));
        order.cancel();
        OrderOutboxEntity cancelOrderOutbox = persistOrderOutbox(order, EventType.ORDER_CANCELLED);
        return new CancelOrderResponse();
    }

    private OrderCreationSpec toOrderCreationSpec(CreateOrderRequest createOrderRequest) {
        return new OrderCreationSpec(createOrderRequest.customerId(), createOrderRequest.restaurantId(),
                createOrderRequest.price(), createOrderRequest.orderItems(), createOrderRequest.address());
    }

    private OrderOutboxEntity persistOrderOutbox(Order order, EventType eventType) {
        OrderOutboxEntity orderOutboxEntity = OrderOutboxEntity.create(order, eventType);
        return orderOutboxRepository.save(orderOutboxEntity);
    }
}