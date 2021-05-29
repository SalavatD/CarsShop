package simpleDao.dao;

import simpleDao.entity.Order;

import java.util.List;

public interface IOrderDAO {

    void add(Order order);

    List<Order> getAll();

    Order getById(int id);

    void remove(int id);
}
