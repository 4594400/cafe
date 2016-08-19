package ua.goit.hiber.dao.interfaces;


import ua.goit.hiber.model.Dish;

import java.util.List;

public interface DishDao {
    void save(Dish dish);
    List<Dish> findAll();
    Dish findByName(String name);

}
