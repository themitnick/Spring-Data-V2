package api.ecommerce.repository;

import api.ecommerce.entity.Address;
import api.ecommerce.entity.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class OneTOneUnidirectionalMappingTest {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    void saveOrderTest() {

        Order order = Order.builder()
                .orderTrackingNumber("8963ACF5")
                .totalQuantity(6)
                .totalPrice(new BigDecimal("850"))
                .status("IN PROGRESS")
                .build();

        Address address = Address.builder()
                .street("Amani")
                .city("Yopougon")
                .state("Big Abidjan")
                .country("Ivory Coast")
                .zipCode("8500")
                .build();

        order.setBillingAddress(address);

        orderRepository.save(order);
    }

    @Test
    void getOrderTest() {

        Order order = orderRepository.findById(2L).get();
        System.out.println(order);
    }

    @Test
    void updateOrderTest() {

        Order order = orderRepository.findById(1L).get();
        order.setStatus("DELIVERED");
        order.getBillingAddress().setZipCode("77500");

        orderRepository.save(order);
    }

    @Test
    void deleteOrderTest() {

        Order order = orderRepository.findById(1L).get();

        orderRepository.delete(order);
    }

}
