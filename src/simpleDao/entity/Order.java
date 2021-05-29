package simpleDao.entity;

public class Order {

    private int id;
    private final int carId;
    private final int clientId;

    public Order(int id, int carId, int clientId) {
        this(carId, clientId);
        this.id = id;
    }

    public Order(int carId, int clientId) {
        this.carId = carId;
        this.clientId = clientId;

    }

    public int getId() {
        return id;
    }

    public int getCarId() {
        return carId;
    }

    public int getClientId() {
        return clientId;
    }
}
