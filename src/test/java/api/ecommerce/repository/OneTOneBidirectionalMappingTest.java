package api.ecommerce.repository;

import api.ecommerce.entity.Address;
import api.ecommerce.entity.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class OneTOneBidirectionalMappingTest {

    // to run this class, you would have to switch to bidirectional mode one to one

    @Autowired
    private AddressRepository addressRepository;

    @Test
    void saveAddressTest() {

        Order order = Order.builder()
                .orderTrackingNumber("QQO85M00")
                .totalQuantity(3)
                .totalPrice(new BigDecimal("1200"))
                .status("IN PROGRESS")
                .build();

        Address address = Address.builder()
                .street("Yamssao")
                .city("Cocody")
                .state("Big Abidjan")
                .country("Ivory Coast")
                .zipCode("1010")
                .build();

        order.setBillingAddress(address);
        address.setOrder(order);

        addressRepository.save(address);
    }

    @Test
    void getAddressTest() {

        Address address = addressRepository.findById(1L).get();
        System.out.println(address);
    }

    @Test
    void updateOrderTest() {

        Address address = addressRepository.findById(2L).get();
        address.setStreet("Big market");
        address.getOrder().setStatus("DELIVERED");

        addressRepository.save(address);
    }

    @Test
    void deleteAddressTest() {

       addressRepository.deleteById(1L);
    }


}
