package nuts.study.msa_saga.orderservice.application.service;

import lombok.RequiredArgsConstructor;
import nuts.study.msa_saga.orderservice.application.required.repository.OrderApprovalOutboxRepository;
import nuts.study.msa_saga.orderservice.application.required.repository.OrderCreationOutboxRepository;
import nuts.study.msa_saga.orderservice.domain.model.Order;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OutboxWriteService {

    private final OrderCreationOutboxRepository orderCreationOutboxRepository;
    private final OrderApprovalOutboxRepository orderApprovalOutboxRepository;

    public void writeOrderCreationOutbox(Order order){

    }

    public void writeOrderApprovalOutbox(){

    }
}
