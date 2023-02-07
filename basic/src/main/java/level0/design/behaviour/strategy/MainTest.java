package level0.design.behaviour.strategy;

public class MainTest {
    public static void main(String[] args) {
        Context context = new Context(new StrategyA());
        context.contextShow();
    }
}
