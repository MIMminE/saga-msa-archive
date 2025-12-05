package nuts.study.msa_saga.orderservice.adapter.client.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantRequest {
    private UUID restaurantId;
    private String orderId;
    private List<RestaurantItem> items;

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RestaurantItem {
        private String productId;
        private int quantity;
    }
}

