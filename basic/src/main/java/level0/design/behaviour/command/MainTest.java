package level0.design.behaviour.command;

import com.google.common.collect.Lists;

/**
 * 调用者不直接持有接收者对象，而是通过命令对象持有
 */
public class MainTest {
    public static void main(String[] args) {
        Order order1 = new Order("order1", 1);
        Order order2 = new Order("order2", 2);

        Receive receive = new Receive("tonny", "super");

        Command impl1 = new CommandImpl1(Lists.newArrayList(order1, order2), receive);

        Caller caller = new Caller();
        caller.add(impl1);
        caller.invoke();
    }
}
