package nuts.study.msa_saga.orderservice.application.required.client;


import nuts.study.msa_saga.orderservice.domain.model.Order;

public interface RestaurantClient {
    boolean checkAndHoldOrderItems(Order order);
}
