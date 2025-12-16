package nuts.study.msa_saga.restaurantservice.domain.service;

import lombok.RequiredArgsConstructor;
import nuts.study.msa_saga.restaurantservice.application.provided.RestaurantService;
import nuts.study.msa_saga.restaurantservice.application.provided.dto.OrderRequest;
import nuts.study.msa_saga.restaurantservice.application.provided.dto.OrderResult;
import nuts.study.msa_saga.restaurantservice.application.required.RestaurantOutboxRepository;
import nuts.study.msa_saga.restaurantservice.application.required.RestaurantRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultRestaurantService implements RestaurantService {

    private final RestaurantOutboxRepository restaurantOutboxRepository;
    private final RestaurantRepository restaurantRepository;

    /**
     *   메시지 프로세스에 의해 호출됨
     */
    @Override
    public OrderResult order(OrderRequest orderRequest) {

        /**
         *  아웃박스 패턴 적용 필요
         *
         */


        return null;
    }

}