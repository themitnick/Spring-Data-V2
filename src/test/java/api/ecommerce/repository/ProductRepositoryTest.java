package api.ecommerce.repository;

import api.ecommerce.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveProductTest() {
        Product product = Product.builder()
                .name("Product 1")
                .description("Description of product 1")
                .price(new BigDecimal("250"))
                .sku("PR001")
                .active(true)
                .urlImage("product1.png")
                .build();

        Product productSaved = productRepository.save(product);

        System.out.println(productSaved.getId());
        System.out.println(productSaved.toString());
    }

    @Test
    void updateProductUsingSaveMethodTest() {

        Long productId = 14L;

        Product product = productRepository.findById(productId).get();

        product.setName("Product 4");
        product.setPrice(new BigDecimal("285"));

        productRepository.save(product);

    }

    @Test
    void findProductByIdTest() {
        Long productId = 13L;

        Product productFound = productRepository.findById(productId).get();
        System.out.println(productFound.getName());
    }

    @Test
    void saveMultipleProductTest() {

        Product product2 = Product.builder()
                .name("Product 2")
                .description("Description of product 2")
                .price(new BigDecimal("185"))
                .sku("PR002")
                .active(true)
                .urlImage("product2.png")
                .build();

        Product product3 = Product.builder()
                .name("Product 3")
                .description("Description of product 3")
                .price(new BigDecimal("963"))
                .sku("PR003")
                .active(false)
                .urlImage("product3.png")
                .build();

        productRepository.saveAll(List.of(product2, product3));
    }

    @Test
    void findAllProductTest() {
        List<Product> products = productRepository.findAll();

        products.forEach( product -> System.out.println(product.getName()));
    }

    @Test
    void deleteProductByIdTest() {
        Long productId = 1L;

        productRepository.deleteById(productId);
    }

    @Test
    void deleteEntityProductTest() {
        // find an entity by ID
        Long productId = 2L;
        Product productFound = productRepository.findById(productId).get();

        // delete entity
        productRepository.delete(productFound);
    }

    @Test
    void deleteAllProductTest() {

        // productRepository.deleteAll();

        Product product1 = productRepository.findById(9L).get();
        Product product2 = productRepository.findById(10L).get();

        productRepository.deleteAll(List.of(product1, product2));
    }

    @Test
    void countProductRecordTest() {
        long countProduct = productRepository.count();

        System.out.println(countProduct);
    }

    @Test
    void existProductTest() {
        Long productId = 1L;

        boolean result = productRepository.existsById(productId);
        System.out.println(result);
    }

}