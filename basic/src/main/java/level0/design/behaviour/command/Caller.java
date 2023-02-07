package level0.design.behaviour.command;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 调用者，
 * 不直接调用接收者， 而是通过持有命令对象达到解耦
 */
public class Caller {
    // 调用者持有一组命令
    private final List<Command> commandList = Lists.newArrayList();

    public void add(Command command) {
        commandList.add(command);
    }

    public void invoke() {
        System.out.println("caller invoke command ... ");
        commandList.forEach(Command::execute);
    }
}
