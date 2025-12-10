package nuts.study.msa_saga.orderservice.domain.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "order_items")
public class OrderItem {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderItemId;

    private String productId;
    private String productName;
    private String productPrice;
    private int quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    @Getter(AccessLevel.NONE)
    private Order order;

    public OrderItem(Product product, int quantity) {
        this.productId = product.getProductId();
        this.productName = product.getName();
        this.productPrice = String.valueOf(product.getPrice());
        this.quantity = quantity;
    }

    public void assignOrder(Order order) {
        this.order = order;
    }
}