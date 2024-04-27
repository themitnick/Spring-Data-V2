package api.ecommerce.repository;

import api.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByName(String name);
    List<Product> findByNameAndDescription(String name, String description);
    Product findDistinctByName(String name);
    List<Product> findByPriceGreaterThan(BigDecimal price);
    List<Product> findByPriceLessThan(BigDecimal price);
    List<Product> findByNameContaining(String name);
    List<Product> findByNameLike(String name);
    List<Product> findByPriceBetween(BigDecimal startPrice, BigDecimal endPrice);
    List<Product> findByCreatedDateBetween(LocalDateTime startDate, LocalDateTime endDate);
    List<Product> findByNameIn(List<String> names);
    List<Product> findFirst2ByOrderByNameAsc();
    List<Product> findTop3ByOrderByPriceDesc();

}
