package api.ecommerce.repository;

import api.ecommerce.entity.Address;
import api.ecommerce.entity.Order;
import api.ecommerce.entity.OrderItem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Set;

@SpringBootTest
public class OneToManyMappingTest {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductRepository productRepository;

    // Save order along with also save it's order items
    @Test
    void saveOrderTest() {
        Order order = Order.builder()
                .orderTrackingNumber("PM00485P")
                .status("IN PROGRESS")
                .totalPrice(new BigDecimal("369.2"))
                .totalQuantity(10)
                .build();

        // Mapping Order item
        OrderItem orderItem = OrderItem.builder()
                .product(productRepository.findById(1L).get())
                .quantity(5)
                .price(new BigDecimal("850"))
                .imageUrl("item1.png")
                .build();

        OrderItem orderItem2 = OrderItem.builder()
                .product(productRepository.findById(2L).get())
                .quantity(33)
                .price(new BigDecimal("400"))
                .imageUrl("item2.png")
                .build();

//        order.getOrderItems().add(orderItem);
//        order.getOrderItems().add(orderItem2);
        order.add(orderItem);
        order.add(orderItem2);

        order.setTotalPrice(order.getTotalPrice());
        order.setTotalQuantity(2);

        // Mapping address
        Address address = Address.builder()
                .street("Konan ya")
                .city("Bouaké")
                .state("Gbêkê")
                .country("Ivory Coast")
                .zipCode("66200")
                .build();

        order.setBillingAddress(address);

        orderRepository.save(order);
    }

    @Test
    void getOrderByIdTest() {
        Order order = orderRepository.findById(2L).get();
        System.out.println(order);
    }

    @Test
    void deleteOrderTest() {
        orderRepository.deleteById(2L);
    }
}
