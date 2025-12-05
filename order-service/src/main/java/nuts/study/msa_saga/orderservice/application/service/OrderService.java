package nuts.study.msa_saga.orderservice.application.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nuts.study.msa_saga.orderservice.application.provided.OrderManager;
import nuts.study.msa_saga.orderservice.domain.OrderCreateRequest;
import nuts.study.msa_saga.orderservice.domain.model.Order;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class OrderService {

    private final OrderManager orderManager;
    private final OutboxWriteService outboxWriteService;

    public Order createOrder(OrderCreateRequest request) {
        log.info("Create Order Request: {}", request);

        Order order = orderManager.createOrder(request);
        outboxWriteService.writeOrderCreationOutbox(order);

        return order;
    }
}