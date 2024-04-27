package api.ecommerce.repository;

import api.ecommerce.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JPQLQueriesTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void findByNameOrDescriptionJPQLIndexParamTest() {
        Product product = productRepository.findByNameOrDescriptionJPQLIndexParam("Product 2", "Description of product 2");

        System.out.println(product.getName());
        System.out.println(product.getPrice());
    }

    @Test
    void findByNameOrDescriptionJPQLNamedParamTest() {
        Product product = productRepository.findByNameOrDescriptionJPQLNamedParam("Product 3", "Description of product 3");

        System.out.println(product.getName());
        System.out.println(product.getPrice());
    }
}
