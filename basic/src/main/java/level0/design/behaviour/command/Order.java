package level0.design.behaviour.command;

public class Order {
    private String name;
    private int num;

    @Override
    public String toString() {
        return "Order{" +
                "name='" + name + '\'' +
                ", num=" + num +
                '}';
    }

    public Order(String name, int num) {
        this.name = name;
        this.num = num;
    }
}
