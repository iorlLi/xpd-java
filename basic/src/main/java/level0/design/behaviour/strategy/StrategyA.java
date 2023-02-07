package level0.design.behaviour.strategy;

/**
 * 策略A
 */
public class StrategyA implements Strategy{
    @Override
    public void show() {
        System.out.println("具体策略 A ");
    }
}
