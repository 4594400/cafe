package ua.goit.hiber.controller;


import org.springframework.transaction.annotation.Transactional;
import ua.goit.hiber.dao.interfaces.DishDao;
import ua.goit.hiber.dao.interfaces.EmployeeDao;
import ua.goit.hiber.dao.interfaces.OrderDao;
import ua.goit.hiber.model.Dish;
import ua.goit.hiber.model.Order;
import ua.goit.hiber.model.OrderStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderController {

    private EmployeeDao employeeDao;
    private DishDao dishDao;
    private OrderDao orderDao;

    @Transactional
    public void createOrder(String waiterName, List<String> dishes, int tableNumber) {
        Order order = new Order();
        order.setWaiter(employeeDao.findByName(waiterName));
        order.setDishes(createDishes(dishes));
        order.setTableNumber(tableNumber);
        order.setOrderDate(new Date());
        order.setOrderStatus(OrderStatus.OPENED);

        orderDao.save(order);

    }

    @Transactional
    public List<Order> getAllOrders() {
        return orderDao.findAll();
    }



    private List<Dish> createDishes(List<String> dishes) {
        List<Dish> result = new ArrayList<>();
        for (String dishName : dishes) {
           result.add(dishDao.findByName(dishName));
        }
        return result;
    }


    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public void setDishDao(DishDao dishDao) {
        this.dishDao = dishDao;
    }

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }
}
