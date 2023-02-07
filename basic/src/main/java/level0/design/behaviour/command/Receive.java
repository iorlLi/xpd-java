package level0.design.behaviour.command;

/**
 * 命令接收者
 */
public class Receive {
    private String name;
    private String title;

    public Receive(String name, String title) {
        this.name = name;
        this.title = title;
    }

    public void receive(Order order) {
        System.out.println(name + "(" + title + ")" + "接收order: " + order );
    }
}
