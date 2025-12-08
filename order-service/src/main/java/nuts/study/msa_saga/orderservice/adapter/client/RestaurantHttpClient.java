package nuts.study.msa_saga.orderservice.adapter.client;

import lombok.extern.slf4j.Slf4j;
import nuts.study.msa_saga.orderservice.adapter.client.dto.RestaurantResponse;
import nuts.study.msa_saga.orderservice.required.client.RestaurantClient;
import nuts.study.msa_saga.orderservice.domain.model.Order;
import nuts.study.msa_saga.orderservice.adapter.client.dto.RestaurantRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.stream.Collectors;

@Component
@Slf4j
public class RestaurantHttpClient implements RestaurantClient {

    private final RestTemplate restTemplate;
    private final String restaurantServiceUrl;

    public RestaurantHttpClient(RestTemplate restTemplate,
                                @Value("${restaurant.service.url:http://localhost:8081}") String restaurantServiceUrl) {
        this.restTemplate = restTemplate;
        this.restaurantServiceUrl = restaurantServiceUrl;
    }

    @Override
    public boolean checkAndHoldOrderItems(Order order) {
        try {
            RestaurantRequest req = toRequest(order);
            String url = restaurantServiceUrl + "/api/v1/restaurants/availability"; // 예시 엔드포인트
            RestaurantResponse resp = restTemplate.postForObject(url, req, RestaurantResponse.class);
            return resp != null && resp.isApproved();
        } catch (RestClientException e) {
            log.error("Failed to call restaurant service: {}", e.getMessage());
            return false;
        }
    }

    private RestaurantRequest toRequest(Order order) {
        var items = order.getOrderItems().stream()
                .map(i -> new RestaurantRequest.RestaurantItem(i.getProduct().getId(), i.getQuantity()))
                .collect(Collectors.toList());
        return new RestaurantRequest(order.getRestaurantId().id(), order.getOrderId().toString(), items);
    }
}