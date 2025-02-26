package com.atl23.orderapp.service.impl;
import com.atl23.orderapp.dao.OrderEntity;
import com.atl23.orderapp.dao.OrderRepository;
import com.atl23.orderapp.dto.OrderDto;
import com.atl23.orderapp.exception.CustomerNotFoundException;
import com.atl23.orderapp.feign.CustomerFeign;
import com.atl23.orderapp.feign.ProductFeign;
import com.atl23.orderapp.mapper.OrderMapper;
import com.atl23.orderapp.service.OrderService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderMapper orderMapper;
    private final OrderRepository orderRepository;
    private final CustomerFeign customerFeign;
    private final ProductFeign productFeign;

    @Override
    @Transactional
    public void createOrder(OrderDto orderDto) {
        BigDecimal multiply = orderDto.getPrice().multiply(BigDecimal.valueOf(orderDto.getCount()));
        customerFeign.decreaseBalance(orderDto.getCustomerId(), multiply);
        productFeign.decreaseCount(orderDto.getProductId(), orderDto.getCount());
        orderRepository.save(orderMapper.toEntity(orderDto));

    }

    @Override
    public OrderDto findById(Long id) {
        return orderRepository.findById(id)
                .map(orderMapper::toDto)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found with id " + id));
    }

    @Override
    public List<OrderDto> findAll() {
        return orderRepository.findAll()
                .stream()
                .map(orderMapper::toDto)
                .toList();
    }

    @Override
    public void updateOrder(Long id, OrderDto orderDto) {
        OrderEntity orderEntity = orderRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found with id " + id));

        orderEntity.setName(orderDto.getName());
        orderEntity.setPrice(orderDto.getPrice());
        orderEntity.setCount(orderEntity.getCount());
        orderRepository.save(orderEntity);
    }


    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

}
