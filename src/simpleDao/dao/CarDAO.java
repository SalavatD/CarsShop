package simpleDao.dao;

import simpleDao.entity.Car;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarDAO implements ICarDAO {

    private Connection connection = null;

    CarDAO() {
        Authorization authorization = new Authorization(new File("config.properties"));
        String url = authorization.getUrl();
        String login = authorization.getLogin();
        String password = authorization.getPassword();
        try {
            connection = DriverManager.getConnection(url, login, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(Car car) {
        PreparedStatement statement = null;
        try {
            int markId = getMarkId(car.getMark(), connection);
            if (markId == -1) {
                statement = connection.prepareStatement("INSERT INTO marks(mark) VALUE(?)");
                statement.setString(1, car.getMark());
                statement.execute();
                ResultSet resultSet = statement.executeQuery("SELECT MAX(id) FROM marks");
                while (resultSet.next()) {
                    markId = resultSet.getInt(1);
                }
            }
            statement = connection.prepareStatement("INSERT INTO cars(mark_id, model, price) VALUE(?, ?, ?)");
            statement.setInt(1, markId);
            statement.setString(2, car.getModel());
            statement.setInt(3, car.getPrice());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private int getMarkId(String markName, Connection connection) {
        int result = -1;
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("SELECT id FROM marks WHERE mark = ?");
            statement.setString(1, markName);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                result = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public List<Car> getAll() {
        List<Car> cars = new ArrayList<>();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM cars JOIN marks ON marks.id = cars.mark_id");
            while (resultSet.next()) {
                cars.add(new Car(
                        resultSet.getInt("id"),
                        resultSet.getString("mark"),
                        resultSet.getString("model"),
                        resultSet.getInt("price")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return cars;
    }

    @Override
    public Car getById(int id) {
        Car car = null;
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("SELECT * FROM cars JOIN marks ON marks.id = cars.mark_id WHERE cars.id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                car = new Car(
                        resultSet.getInt("id"),
                        resultSet.getString("mark"),
                        resultSet.getString("model"),
                        resultSet.getInt("price")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return car;
    }

    @Override
    public void updatePrice(int price, int carId) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("UPDATE cars SET price = ? WHERE id = ?");
            statement.setInt(1, price);
            statement.setInt(2, carId);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void remove(int id) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("DELETE FROM cars WHERE id = ?");
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
