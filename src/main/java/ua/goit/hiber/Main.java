package ua.goit.hiber;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.goit.hiber.controller.DishController;
import ua.goit.hiber.controller.EmployeeController;
import ua.goit.hiber.controller.OrderController;
import ua.goit.hiber.model.Dish;

import java.util.ArrayList;
import java.util.List;


public class Main {

    private EmployeeController employeeController;
    private DishController dishController;
    private OrderController orderController;

    private boolean reInit;

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml", "hibernate-context.xml");
        Main main = applicationContext.getBean(Main.class);
        main.start();
    }

    public void init() {
        if(reInit) {
            //orderController.removeAllOrders();

        }
    }

    private void start() {
        employeeController.createEmployee();
        dishController.createDish();

        List<String> dishes1 = new ArrayList<>();
        dishes1.add("Plov");
        dishes1.add("Salad");

        orderController.createOrder("John", dishes1, 1);

        List<String> dishes2 = new ArrayList<>();
        dishes2.add("Salad");
        dishes2.add("Potato");

        orderController.createOrder("John", dishes2, 2);

        orderController.getAllOrders().forEach(System.out::println);



       /* System.out.println("-------------------------------------------------------------------------");
        employeeController.getAllEmployees().forEach(System.out::println);
        dishController.getAllDishes().forEach(System.out::println);
        System.out.println("---------------------------Employee by name----------------------------------------------");

        System.out.println(employeeController.getEmployeeByName("John"));
        System.out.println("---------------------------Dish by name----------------------------------------------");
        System.out.println(dishController.getDishByName("Plov"));*/
    }

    public void setEmployeeController(EmployeeController employeeController) {
        this.employeeController = employeeController;
    }

    public void setDishController(DishController dishController) {
        this.dishController = dishController;
    }

    public void setOrderController(OrderController orderController) {
        this.orderController = orderController;
    }
}
