package level0.design.singleton.demo2;

/**
 * 懒汉模式：
 */
public class SingletonX {
    private static SingletonX singletonX1;
    private static SingletonX singletonX2;
    private static volatile SingletonX singletonX3;

    private SingletonX() {

    }

    /**
     * 存在并发问题，
     */
    public static SingletonX getInstance1() {
        if (singletonX1 == null) {
            singletonX1 = new SingletonX();
        }
        return singletonX1;
    }

    /**
     * 方法级别枷锁：锁是加在类上的，所有该类或实例都要同步
     */
    public static synchronized SingletonX getSingleton2() {
        if (singletonX2 == null) {
            singletonX2 = new SingletonX();
        }
        return singletonX2;
    }

    /**
     * 创建对象： 1. 分配内存 2. 调用构造器，初始化对象  3. 返回引用
     * 指令重排后，可能会 1 -3 -2
     * <p>
     * 因此：线程t1： 1.获取 synchronized 锁， 2. new 实例化对象，
     * 此时如果指令重排，执行了重排后的 1-3 指令。
     * 线程t2到来，此时【A】处校验已经不为null
     * 引用指向的对象还没初始化，导致控制着
     * <p>
     * volatile: 1. 内存可见 2. 禁止指令重排
     */
    public static SingletonX getSingletonX3() {
        if (singletonX3 == null) {  // A
            synchronized (SingletonX.class) {
                if (singletonX3 == null) {
                    singletonX3 = new SingletonX();
                }
            }
        }
        return singletonX3;
    }

}
