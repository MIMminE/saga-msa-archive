package nuts.study.msa_saga.orderservice.application.service;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nuts.study.msa_saga.orderservice.application.entity.OrderOutboxEntity;
import nuts.study.msa_saga.orderservice.application.required.repository.OrderItemRepository;
import nuts.study.msa_saga.orderservice.application.required.repository.ProductRepository;
import nuts.study.msa_saga.orderservice.domain.model.Order;
import nuts.study.msa_saga.orderservice.application.provided.OrderService;
import nuts.study.msa_saga.orderservice.application.provided.dto.CancelOrderResponse;
import nuts.study.msa_saga.orderservice.domain.CreateOrderRequest;
import nuts.study.msa_saga.orderservice.application.provided.dto.CreateOrderResponse;
import nuts.study.msa_saga.orderservice.application.provided.dto.GetOrderResponse;
import nuts.study.msa_saga.orderservice.application.required.repository.OrderOutboxRepository;
import nuts.study.msa_saga.orderservice.application.required.repository.OrderRepository;
import nuts.study.msa_saga.orderservice.domain.model.OrderItem;
import nuts.study.msa_saga.orderservice.domain.model.Product;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
@Slf4j
public class DefaultOrderService implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final OrderItemRepository orderItemRepository;
    private final OrderOutboxRepository orderOutboxRepository;

    @Override
    @Transactional
    public CreateOrderResponse createOrder(CreateOrderRequest request) {
        // 1. 주문 생성 정책에 따라 주문 생성 및 저장
        Order order = Order.createOrder(request);

        request.products().forEach((productId, quantity) -> {
            Product product = getProduct(productId);
            OrderItem orderItem = new OrderItem(product, quantity);
            order.addOrderItem(orderItem);
        });

        Order savedOrder = orderRepository.save(order);

        // 2. 주문 생성 아웃박스 레코드 저장
        OrderOutboxEntity createOrderOutbox = persistOrderOutbox(savedOrder, EventType.ORDER_CREATED);

        return new CreateOrderResponse(savedOrder.getOrderId(), createOrderOutbox.getTrackingId()
                , savedOrder.getRestaurantId(), savedOrder.getCustomerId(), savedOrder.getOrderStatus());
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

    private OrderOutboxEntity persistOrderOutbox(Order order, EventType eventType) {
        OrderOutboxEntity orderOutboxEntity = OrderOutboxEntity.create(order, eventType);
        return orderOutboxRepository.save(orderOutboxEntity);
    }

    private Product getProduct(String productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found: " + productId));

    }
}