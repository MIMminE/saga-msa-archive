package nuts.study.msa_saga.orderservice.application.required.repository;

import nuts.study.msa_saga.orderservice.domain.model.Product;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface ProductRepository extends Repository<Product, String> {

    Optional<Product> findById(String id);
}
