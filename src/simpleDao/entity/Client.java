package simpleDao.entity;

public class Client {

    private int id;
    private final String name;
    private final int age;
    private final String phone;

    public Client(int id, String name, int age, String phone) {
        this(name, age, phone);
        this.id = id;
    }

    public Client(String name, int age, String phone) {
        this.name = name;
        this.age = age;
        this.phone = phone;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }
}
