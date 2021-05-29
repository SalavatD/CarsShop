package simpleDao.dao;

import simpleDao.entity.Car;

import java.util.List;

public interface ICarDAO {

    void add(Car car);

    List<Car> getAll();

    Car getById(int id);

    void updatePrice(int price, int carId);

    void remove(int id);
}
