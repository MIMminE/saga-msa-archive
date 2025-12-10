package nuts.study.msa_saga.restaurantservice.domain.model;

import jakarta.persistence.*;
import lombok.Getter;

import static lombok.AccessLevel.NONE;

@Entity
@Getter
public class ProductInventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inventoryId;

    private Long quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    @Getter(NONE)
    private Restaurant restaurant;
}