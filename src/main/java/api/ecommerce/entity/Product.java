package api.ecommerce.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Table(
        name = "products",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "sku_unique",
                        columnNames = "stock_keeping_unit")
        }

)

@NamedQuery(
        name = "Product.findByPrice",
        query = "SELECT p FROM Product p WHERE p.price = ?1"
)

@NamedQueries(
        {
                @NamedQuery(
                        name = "Product.findAllOrderByNameDesc",
                        query = "SELECT p FROM Product p ORDER BY p.name DESC"
                ),
                @NamedQuery(
                        name = "Product.findBySku",
                        query = "SELECT p FROM Product p WHERE p.sku = :sku"
                )
        }
)

@NamedNativeQuery(
        name = "Product.findByUrlImage",
        query = "SELECT * FROM products p WHERE p.url_image = :urlImage",
        resultClass = Product.class
)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "stock_keeping_unit", nullable = false)
    private String sku;
    @Column(nullable = false, length = 150)
    private String name;
    private String description;
    private BigDecimal price;
    private boolean active;
    private String urlImage;
    @CreationTimestamp
    private LocalDateTime createdDate;
    @UpdateTimestamp
    private LocalDateTime updatedDate;
}
