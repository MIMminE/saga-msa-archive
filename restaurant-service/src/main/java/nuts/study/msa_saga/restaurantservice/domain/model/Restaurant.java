package nuts.study.msa_saga.restaurantservice.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

import static jakarta.persistence.CascadeType.*;
import static jakarta.persistence.FetchType.*;

@Entity
@Getter
public class Restaurant {

    @Id
    private UUID restaurantId;
    private String name;
    private String grade;

    @OneToMany(mappedBy = "restaurant", orphanRemoval = true, cascade = ALL, fetch = LAZY)
    private List<ProductInventory> inventories;
}