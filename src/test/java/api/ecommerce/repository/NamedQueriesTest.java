package api.ecommerce.repository;

import api.ecommerce.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
public class NamedQueriesTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void findByPriceTest() {
        Product product = productRepository.findByPrice(new BigDecimal(250));

        System.out.println(product.getSku());
        System.out.println(product.getPrice());
    }

    @Test
    void findBySkuTest() {
        Product product = productRepository.findBySku("PR003");

        System.out.println(product.getName());
        System.out.println(product.getSku());
    }

    @Test
    void findAllOrderByNameDescTest() {
        List<Product> products = productRepository.findAllOrderByNameDesc();

        products.forEach(product -> {
            System.out.println(product.getName());
        });
    }

    @Test
    void findByUrlImageNamedNativeSQLQueryTest() {
        Product product = productRepository.findByUrlImage("product2.png");

        System.out.println(product.getName());
        System.out.println(product.getSku());
    }
}
