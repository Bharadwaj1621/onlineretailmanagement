package com.retailmanagementsystem.dao;

import org.springframework.data.repository.CrudRepository;

import com.retailmanagementsystem.entity.OrderDetail;
import com.retailmanagementsystem.entity.User;

import java.util.List;

public interface OrderDetailDao extends CrudRepository<OrderDetail, Integer> {
    public List<OrderDetail> findByUser(User user);

    public List<OrderDetail> findByOrderStatus(String status);
}
