package level0.design.behaviour.strategy;

/**
 * 环境类
 */
public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void contextShow(){
        System.out.println("环境类使用构造器传入的策略");
        strategy.show();
    }
}
