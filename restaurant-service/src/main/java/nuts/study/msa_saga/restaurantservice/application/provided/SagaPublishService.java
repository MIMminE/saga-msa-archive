package nuts.study.msa_saga.restaurantservice.application.provided;


/**
 * 어플리케이션에서 이벤트를 발행할 떄 사용한다.
 */
public interface SagaPublishService {

    void publish();
}
