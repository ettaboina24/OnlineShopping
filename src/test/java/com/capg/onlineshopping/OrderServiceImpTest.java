package com.capg.onlineshopping;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.onlineshopping.entity.Order;
import com.capg.onlineshopping.entity.Product;
import com.capg.onlineshopping.repository.CartRepository;
import com.capg.onlineshopping.repository.OrderRepository;
import com.capg.onlineshopping.repository.ProductRepository;
import com.capg.onlineshopping.service.OrderServiceImpl;

@SpringBootTest
public class OrderServiceImpTest {
	@InjectMocks
    private OrderServiceImpl orderService;
    @Mock
    private OrderRepository orderRepository;
    @Mock
    private CartRepository cartRepository;
    @Mock
    private ProductRepository productRepository;
    @BeforeEach

    void setUp() {

        MockitoAnnotations.initMocks(this);

    }


 
    @Test

    void testCancelOrder() {

        // Mocking order

        Order mockOrder = new Order();

        mockOrder.setOrderId(1);

        mockOrder.setOrderStatus("Completed");

        mockOrder.setProductId(101);
        // Mocking product

        Product mockProduct = new Product();

        mockProduct.setProductId(101);

        mockProduct.setQuantity(5);
        // Mocking repository calls

        when(orderRepository.findById(1)).thenReturn(Optional.of(mockOrder));

        when(productRepository.findById(101)).thenReturn(Optional.of(mockProduct));

        when(orderRepository.save(any(Order.class))).thenAnswer(invocation -> invocation.getArgument(0));

        when(productRepository.save(any(Product.class))).thenAnswer(invocation -> invocation.getArgument(0));
        // Actual test

        String result = orderService.cancelOrder(1);
        // Assertions

        assertEquals("Order Cancelled Successfully", result);

        assertEquals("Cancelled", mockOrder.getOrderStatus());

        assertEquals(6, mockProduct.getQuantity()); // Quantity increased by 1

        verify(orderRepository, times(1)).findById(1);

        verify(orderRepository, times(1)).save(any(Order.class));

        verify(productRepository, times(1)).findById(101);

        verify(productRepository, times(1)).save(any(Product.class));

    }
    @Test

    void testGetAllOrders() {

        // Mocking orders

        Order order1 = new Order();

        order1.setOrderId(1);

        Order order2 = new Order();

        order2.setOrderId(2);
        List<Order> orderList = new ArrayList<>();

        orderList.add(order1);

        orderList.add(order2);
        // Mocking repository calls

        when(orderRepository.findAll()).thenReturn(orderList);
        // Actual test

        List<Order> result = orderService.getAllOrders();
        // Assertions

        assertNotNull(result);

        assertEquals(2, result.size());

        verify(orderRepository, times(1)).findAll();
}
}
