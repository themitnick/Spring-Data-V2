package api.ecommerce.repository;

import api.ecommerce.entity.Product;
import api.ecommerce.entity.ProductCategory;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;
    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveProductCategoryTest() {
        ProductCategory productCategory1 = ProductCategory.builder()
                .CategoryName("Backend")
                .description("Backend developer program")
                .build();

        ProductCategory productCategory2 = ProductCategory.builder()
                .CategoryName("Frontend")
                .description("Frontend developer program")
                .build();

        ProductCategory productCategory3 = ProductCategory.builder()
                .CategoryName("FullStack")
                .description("FullStack developer program")
                .build();

        productCategoryRepository.saveAll(List.of(productCategory1, productCategory2, productCategory3));

    }

    @Test
    void saveProductWithCategoryTest() {

        ProductCategory productCategory1 = productCategoryRepository.findById(1L).get();
        ProductCategory productCategory2 = productCategoryRepository.findById(2L).get();
        ProductCategory productCategory3 = productCategoryRepository.findById(3L).get();

        Product product23 = Product.builder()
                .name("Product 23")
                .description("Description of product 23")
                .price(new BigDecimal("11.66"))
                .sku("PR0023")
                .active(true)
                .urlImage("product23.png")
                .category(productCategory1)
                .build();

        Product product24 = Product.builder()
                .name("Product 23")
                .description("Description of product 24")
                .price(new BigDecimal("66.66"))
                .sku("PR0024")
                .active(false)
                .urlImage("product24.png")
                .category(productCategory2)
                .build();


        Product product25 = Product.builder()
                .name("Product 25")
                .description("Description of product 25")
                .price(new BigDecimal("785.66"))
                .sku("PR0025")
                .active(false)
                .urlImage("product25.png")
                .category(productCategory3)
                .build();

        productRepository.saveAll(List.of(product23, product24, product25));
    }

    @Test
    @Transactional
    void getProductCategoryTest() {
        ProductCategory productCategory = productCategoryRepository.findById(1L).get();
        System.out.println(productCategory.getProducts());
    }


}