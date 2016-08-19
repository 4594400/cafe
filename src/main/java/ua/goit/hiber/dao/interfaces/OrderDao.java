package ua.goit.hiber.dao.interfaces;


import ua.goit.hiber.model.Order;

import java.util.List;

public interface OrderDao {
    void save(Order order);
    List<Order> findAll();
}
