package com.vishal.orderService.service;

import com.vishal.orderService.dto.OrderDTO;
import com.vishal.orderService.dto.OrderDTOFromFE;
import com.vishal.orderService.dto.UserDTO;
import com.vishal.orderService.entity.Order;
import com.vishal.orderService.mapper.OrderMapper;
import com.vishal.orderService.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    OrderRepo orderRepo;

    @Autowired
    SequenceGenerator sequenceGenerator;

    @Autowired
    RestTemplate restTemplate;



    public OrderDTO saveOrderInDb(OrderDTOFromFE orderDetails) {
        Integer newOrderID = sequenceGenerator.generateNextOrderId();
        UserDTO userDTO = fetchUserDetailsFromUserId(orderDetails.getUserId());
        //UserDTO userDTO = null;
        Order orderToBeSaved = new Order(newOrderID, orderDetails.getFoodItemsList(), orderDetails.getRestaurant(), userDTO );
        orderRepo.save(orderToBeSaved);
        return OrderMapper.INSTANCE.mapOrderToOrderDTO(orderToBeSaved);
    }

    private UserDTO fetchUserDetailsFromUserId(Integer userId) {
        return restTemplate.getForObject("http://USERSERVICE/user/fetchUserById/"+userId, UserDTO.class);
    }
}
