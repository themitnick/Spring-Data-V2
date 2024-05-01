package api.ecommerce.repository;

import api.ecommerce.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
public class PaginationAndSortingTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void pagination() {
        int pageNumber = 0;
        int pageSize = 5;

        //Create Pageable object
        Pageable pageable = PageRequest.of(pageNumber, pageSize);

        // findAll method and pass pageable instance
        Page<Product> page = productRepository.findAll(pageable);

        List<Product> products = page.getContent();

        products.forEach(System.out::println);

        // Total pages
        int totalPage = page.getTotalPages();

        // Total elements
        long totalElements = page.getTotalElements();

        // Number of elements per page
        long numberElementsOfPage = page.getNumberOfElements();

        // Size
        int size = page.getSize();

        // Last element
        boolean isLast = page.isLast();

        // First element
        boolean isFirst = page.isFirst();

        System.out.println("Total Page -> " + totalPage);
        System.out.println("Total Elements -> " + totalElements);
        System.out.println("Number elements of this page -> " + numberElementsOfPage);
        System.out.println("Size -> " + size);
        System.out.println("First Element -> " + isFirst);
        System.out.println("Last Element -> " + isLast);
    }

    @Test
    void sorting() {
        String sortBy = "price";

        Sort orderSort = Sort.by(sortBy).descending();
        List<Product> products = productRepository.findAll(orderSort);
        products.forEach(System.out::println);
    }

    @Test
    void sortingByMultipleFields() {
        String sortByName = "name";
        String sortByPrice = "price";

        Sort nameSorted = Sort.by(sortByName);
        Sort priceSorted = Sort.by(sortByPrice);

        Sort groupBySort = priceSorted.and(nameSorted);

        List<Product> products = productRepository.findAll(groupBySort);

        products.forEach(System.out::println);
    }

    @Test
    void paginationAndSorting() {
        int pageNumber = 4;
        int pageSize = 5;

        String sortBy = "price";

        Sort sort = Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);

        Page<Product> page = productRepository.findAll(pageable);
        List<Product> products = page.getContent();

        products.forEach(System.out::println);

        // Total pages
        int totalPage = page.getTotalPages();

        // Total elements
        long totalElements = page.getTotalElements();

        // Number of elements per page
        long numberElementsOfPage = page.getNumberOfElements();

        // Size
        int size = page.getSize();

        // Last element
        boolean isLast = page.isLast();

        // First element
        boolean isFirst = page.isFirst();

        System.out.println("*********************************************************************");
        System.out.println("Total Page -> " + totalPage);
        System.out.println("Total Elements -> " + totalElements);
        System.out.println("Number elements of this page -> " + numberElementsOfPage);
        System.out.println("Size -> " + size);
        System.out.println("First Element -> " + isFirst);
        System.out.println("Last Element -> " + isLast);
    }

}
