package com.myapp.demo.config;

import com.myapp.demo.entities.*;
import com.myapp.demo.entities.enums.OrderStatus;
import com.myapp.demo.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;


    @Override
    public void run(String... args) throws Exception {

        //category
        Category cat1 = new Category(null, "computers");
        Category cat2 = new Category(null, "Books");

        categoryRepository.saveAll(Arrays.asList(cat1, cat2));

        //product
        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");

        productRepository.saveAll(Arrays.asList(p1, p2, p3));

        //add category
        p1.getCategories().add(cat2);
        p2.getCategories().add(cat1);
        p3.getCategories().add(cat1);

        productRepository.saveAll(Arrays.asList(p1, p2, p3));

        //User
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        userRepository.saveAll(Arrays.asList(u1, u2));

        //order
        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID,  u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.PAID, u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);

        orderRepository.saveAll(Arrays.asList(o1, o2,o3));

        //payments
        Payment payment1 = new Payment(null, Instant.parse("2019-06-20T20:00:07Z"), o1);
        Payment payment2 = new Payment(null, Instant.parse("2019-07-21T03:55:10Z"), o2);
        Payment payment3 = new Payment(null, Instant.parse("2019-07-22T15:25:22Z"), o3);

        //set payments
        o1.setPayment(payment1);
        o2.setPayment(payment2);
        o3.setPayment(payment3);

        orderRepository.saveAll(Arrays.asList(o1, o2,o3));


        OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
        OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
        OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());

        orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3));



    }
}
