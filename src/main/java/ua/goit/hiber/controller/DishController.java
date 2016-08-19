package ua.goit.hiber.controller;


import org.springframework.transaction.annotation.Transactional;
import ua.goit.hiber.dao.interfaces.DishDao;
import ua.goit.hiber.model.Dish;
import ua.goit.hiber.model.DishCategory;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DishController {

    private DishDao dishDao;

    @Transactional
    public void createDish() {
        Dish plov = new Dish();
        plov.setName("Plov");
        plov.setDishCategory(DishCategory.MAIN);
        plov.setPrice(25.5);
        plov.setWeight(350.0);

        Dish salad = new Dish();
        salad.setName("Salad");
        salad.setDishCategory(DishCategory.SALAD);
        salad.setPrice(10.5);
        salad.setWeight(150.0);

        Dish potato = new Dish();
        potato.setName("Potato");
        potato.setDishCategory(DishCategory.SIDE_DISH);
        potato.setPrice(20.0);
        potato.setWeight(200.0);

        Set<Dish> dishes = new HashSet<>(dishDao.findAll());

        if(!dishes.contains(plov)) {
            dishDao.save(plov);
        }
        if(!dishes.contains(salad)) {
            dishDao.save(salad);
        }
        if(!dishes.contains(potato)) {
            dishDao.save(potato);
        }
    }

    @Transactional
    public List<Dish> getAllDishes() {
        return dishDao.findAll();
    }


    @Transactional public Dish getDishByName(String name) {
        return dishDao.findByName(name);
    }

    public void setDishDao(DishDao dishDao) {
        this.dishDao = dishDao;
    }
}
