package com.howtodoinjava.app;


import com.howtodoinjava.app.model.order.Order;
import com.howtodoinjava.app.model.user.User;
import com.howtodoinjava.app.repositories.order.OrderRepository;
import com.howtodoinjava.app.repositories.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class AppTest {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private OrderRepository orderRepository;

  @Test
  void saveUserDataInDB() {

    User user = new User();
    user.setEmail("opt@gmail.com");
    user.setFirstName("gulam");
    user.setLastName("samdani");
    user.setId(2);

    User savedUser = userRepository.save(user);
    Optional<User> userData = userRepository.findById(savedUser.getId());
    assertTrue(userData.isPresent());

  }

  @Test
  void saveOrderDataInDB() {

    Order order = new Order();
    order.setProductName("test");
    order.setOrderAmount(500);
    order.setUserId(2);
    order.setId(2);

    Order savedOrder = orderRepository.save(order);
    Optional<Order> orderData = orderRepository.findById(savedOrder.getId());
    assertTrue(orderData.isPresent());
  }

}

