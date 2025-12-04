package nuts.study.msa_saga.orderservice.application.port.persistence;

import nuts.study.msa_saga.orderservice.domain.model.Order;

public interface OrderPersistence {
    Order save(Order order);
}
