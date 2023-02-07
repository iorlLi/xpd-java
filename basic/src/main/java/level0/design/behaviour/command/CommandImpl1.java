package level0.design.behaviour.command;

import java.util.List;

public class CommandImpl1 implements Command {
    private List<Order> order;
    private Receive receive;

    public CommandImpl1(List<Order> order, Receive receive) {
        this.order = order;
        this.receive = receive;
    }

    @Override
    public void execute() {
        System.out.println("command impl  start");
        order.forEach(receive::receive);
        System.out.println("command impl  end ");
    }
}
