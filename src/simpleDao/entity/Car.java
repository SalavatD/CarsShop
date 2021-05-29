package simpleDao.entity;

public class Car {

    private int id;
    private final String mark;
    private final String model;
    private final int price;

    public Car(int id, String mark, String model, int price) {
        this(mark, model, price);
        this.id = id;
    }

    public Car(String mark, String model, int price) {
        this.mark = mark;
        this.model = model;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public String getMark() {
        return mark;
    }

    public String getModel() {
        return model;
    }

    public int getPrice() {
        return price;
    }
}
