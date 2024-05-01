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

        Product product5 = Product.builder()
                .name("Product 5")
                .description("Description of product 5")
                .price(new BigDecimal("96.33"))
                .sku("PR005")
                .active(true)
                .urlImage("product5.png")
                .build();

        Product product6 = Product.builder()
                .name("Product 6")
                .description("Description of product 6")
                .price(new BigDecimal("100"))
                .sku("PR006")
                .active(false)
                .urlImage("product6.png")
                .build();

        Product product7 = Product.builder()
                .name("Product 2")
                .description("Description of product 7")
                .price(new BigDecimal("785"))
                .sku("PR007")
                .active(false)
                .urlImage("product7.png")
                .build();

        Product product8 = Product.builder()
                .name("Product 8")
                .description("Description of product 8")
                .price(new BigDecimal("485"))
                .sku("PR008")
                .active(false)
                .urlImage("product8.png")
                .build();

        Product product9 = Product.builder()
                .name("Product 9")
                .description("Description of product 9")
                .price(new BigDecimal("185"))
                .sku("PR009")
                .active(true)
                .urlImage("product9.png")
                .build();

        Product product10 = Product.builder()
                .name("Product 10")
                .description("Description of product 10")
                .price(new BigDecimal("10.5"))
                .sku("PR0010")
                .active(false)
                .urlImage("product10.png")
                .build();

        Product product11 = Product.builder()
                .name("Product 5")
                .description("Description of product 11")
                .price(new BigDecimal("96.25"))
                .sku("PR0011")
                .active(true)
                .urlImage("product11.png")
                .build();

        Product product12 = Product.builder()
                .name("Product 12")
                .description("Description of product 12")
                .price(new BigDecimal("250"))
                .sku("PR0012")
                .active(false)
                .urlImage("product12.png")
                .build();

        Product product13 = Product.builder()
                .name("Product 13")
                .description("Description of product 13")
                .price(new BigDecimal("785"))
                .sku("PR0013")
                .active(false)
                .urlImage("product13.png")
                .build();

        Product product14 = Product.builder()
                .name("Product 14")
                .description("Description of product 14")
                .price(new BigDecimal("500"))
                .sku("PR0014")
                .active(false)
                .urlImage("product14.png")
                .build();

        Product product15 = Product.builder()
                .name("Product 15")
                .description("Description of product 15")
                .price(new BigDecimal("305"))
                .sku("PR0015")
                .active(true)
                .urlImage("product15.png")
                .build();

        Product product16 = Product.builder()
                .name("Product 16")
                .description("Description of product 16")
                .price(new BigDecimal("666.66"))
                .sku("PR0016")
                .active(false)
                .urlImage("product16.png")
                .build();

        Product product17 = Product.builder()
                .name("Product 17")
                .description("Description of product 17")
                .price(new BigDecimal("8"))
                .sku("PR0017")
                .active(false)
                .urlImage("product17.png")
                .build();

        Product product18 = Product.builder()
                .name("Product 18")
                .description("Description of product 18")
                .price(new BigDecimal("500"))
                .sku("PR0018")
                .active(false)
                .urlImage("product18.png")
                .build();

        Product product19 = Product.builder()
                .name("Product 19")
                .description("Description of product 19")
                .price(new BigDecimal("300"))
                .sku("PR0019")
                .active(true)
                .urlImage("product19.png")
                .build();

        Product product20 = Product.builder()
                .name("Product 20")
                .description("Description of product 20")
                .price(new BigDecimal("1000"))
                .sku("PR0020")
                .active(false)
                .urlImage("product20.png")
                .build();

        Product product21 = Product.builder()
                .name("Product 21")
                .description("Description of product 21")
                .price(new BigDecimal("55"))
                .sku("PR0021")
                .active(false)
                .urlImage("product21.png")
                .build();

        Product product22 = Product.builder()
                .name("Product 22")
                .description("Description of product 22")
                .price(new BigDecimal("950.66"))
                .sku("PR0022")
                .active(true)
                .urlImage("product22.png")
                .build();

        productRepository.saveAll(
                List.of(product2, product3, product5, product6, product7, product8, product9, product10, product11, product12, product13, product14, product15, product16, product17,
                        product18, product19, product20, product21, product22)
        );
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