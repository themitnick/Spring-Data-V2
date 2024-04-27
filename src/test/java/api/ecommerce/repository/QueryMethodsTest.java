package api.ecommerce.repository;

import api.ecommerce.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class QueryMethodsTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void findProductByNameTest() {
        String productName = "Product 1";

        Product product = productRepository.findByName(productName);

        System.out.println("Product Name : " + product.getName());
    }

    @Test
    void findProductByNameAndDescriptionTest() {
        String productName = "Product 1";
        String productDescription = "Description of product 1";

        List<Product> products = productRepository.findByNameAndDescription(productName, productDescription);

        products.forEach( product -> {
            System.out.println(product.getId());
            System.out.println(product.getPrice());
        });
    }

    @Test
    void findDistinctByNameTest() {
        Product product = productRepository.findDistinctByName("Product 2");

        System.out.println(product.getSku());
    }

    @Test
    void findByPriceGreaterThanTest() {

        List<Product> products = productRepository.findByPriceGreaterThan(new BigDecimal(200));

        products.forEach( product -> System.out.println(product.getPrice()));

    }

    @Test
    void findByPriceLessThanTest() {

        List<Product> products = productRepository.findByPriceLessThan(new BigDecimal(200));

        products.forEach( product -> System.out.println(product.getPrice()));

    }

    @Test
    void findByNameContainingTest() {
        List<Product> products = productRepository.findByNameContaining("Product 1");

        products.forEach(product -> {
            System.out.println(product.getName());
            System.out.println(product.getSku());
        });
    }

    @Test
    void findByNameLikeTest() {
        List<Product> products = productRepository.findByNameLike("Product 1");

        products.forEach(product -> {
            System.out.println(product.getName());
            System.out.println(product.getSku());
        });
    }

    @Test
    void findByPriceBetweenTest() {
        List<Product> products = productRepository.findByPriceBetween(new BigDecimal(10), new BigDecimal(249));

        products.forEach(product -> {
            System.out.println(product.getSku());
            System.out.println(product.getPrice());
        });
    }

    @Test
    void findByCreatedDateBetweenTest() {
        LocalDateTime startDate = LocalDateTime.of(2024, 4, 22,10,30,25);
        LocalDateTime endDate = LocalDateTime.of(2024, 4, 22,18, 0, 0);

        List<Product> products = productRepository.findByCreatedDateBetween(startDate, endDate);

        products.forEach(product -> {
            System.out.println(product.getSku());
            System.out.println(product.getPrice());
        });
    }

    @Test
    void findByNameInTest() {
        List<String> productNames = List.of("Product 1", "Product 4");
        List<Product> products = productRepository.findByNameIn(productNames);

        products.forEach(product -> {
            System.out.println(product.getSku());
            System.out.println(product.getPrice());
        });
    }

    @Test
    void findFirst2ByOrderByNameAscTest() {
        List<Product> products = productRepository.findFirst2ByOrderByNameAsc();

        products.forEach(product -> {
            System.out.println(product.getSku());
            System.out.println(product.getPrice());
        });
    }

    @Test
    void findTop3ByOrderByPriceDescTest() {
        List<Product> products = productRepository.findTop3ByOrderByPriceDesc();

        products.forEach(product -> {
            System.out.println(product.getSku());
            System.out.println(product.getPrice());
        });
    }

}
