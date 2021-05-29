package simpleDao.dao;

import simpleDao.entity.Car;
import simpleDao.entity.Client;

import java.util.List;

public interface IClientDAO {

    void add(Client client);

    List<Client> getAll();

    Client getById(int id);

    void remove(int id);
}
