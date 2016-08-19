package ua.goit.hiber.dao.hibernate;

import org.hibernate.SessionFactory;
import ua.goit.hiber.dao.interfaces.OrderDao;
import ua.goit.hiber.model.Order;

import java.util.List;


public class OrderDaoHiber implements OrderDao {

    private SessionFactory sessionFactory;

    @Override
    public void save(Order order) {
        sessionFactory.getCurrentSession().save(order);
    }

    @Override
    public List<Order> findAll() {
        return sessionFactory.getCurrentSession().createQuery("select o from Order o").list();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
