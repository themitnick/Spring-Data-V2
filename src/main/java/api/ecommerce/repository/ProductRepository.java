package api.ecommerce.repository;

import api.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // Query Methods
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

    // Define JPQL query using @Query annotation with index or position parameters
    @Query("SELECT p FROM Product p WHERE p.name = ?1 OR p.description = ?2")
    Product findByNameOrDescriptionJPQLIndexParam(String name, String description);

    // Define JPQL query using @Query annotation with named parameters
    @Query("SELECT p FROM Product p WHERE p.name = :name OR p.description = :description")
    Product findByNameOrDescriptionJPQLNamedParam(@Param("name") String name, @Param("description") String description);

    // Define Native SQL query using @Query annotation with index or position parameters
    @Query(value = "SELECT * FROM products p WHERE p.name = ?1 OR p.description = ?2", nativeQuery = true)
    Product findByNameOrDescriptionNativeSQLIndexParam(String name, String description);
    // Define Native SQL query using @Query annotation with named parameters
    @Query(value = "SELECT * FROM products p WHERE p.name = :name OR p.description = :description", nativeQuery = true)
    Product findByNameOrDescriptionNativeSQLNamedParam(@Param("name") String name, @Param("description") String description);

    //Define Named JPQL Query
    Product findByPrice(BigDecimal price);
    List<Product> findAllOrderByNameDesc();
    Product findBySku(@Param("sku") String sku);

    //Define Named native SQL query
    @Query(nativeQuery = true)
    Product findByUrlImage(@Param("urlImage") String urlImage);

}
