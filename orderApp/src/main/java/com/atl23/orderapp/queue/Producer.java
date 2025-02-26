package com.atl23.orderapp.queue;

import com.atl23.orderapp.dto.OrderDto;
import com.atl23.orderapp.rabbitDto.RabOrderDto;
import com.atl23.orderapp.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Producer {

     private final RabbitTemplate rabbitTemplate;
     private  final OrderService orderService;
     public RabOrderDto sendMessage(OrderDto orderDto){
          rabbitTemplate.convertAndSend("MsQueue",orderDto);
          orderService.createOrder(orderDto);
          return new RabOrderDto("Sifarisiniz qebul edildi ");
     }
}
