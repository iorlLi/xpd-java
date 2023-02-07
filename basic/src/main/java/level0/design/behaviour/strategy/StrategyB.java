package level0.design.behaviour.strategy;

/**
 * 策略A
 */
public class StrategyB implements Strategy{
    @Override
    public void show() {
        System.out.println("具体策略 B ");
    }
}
