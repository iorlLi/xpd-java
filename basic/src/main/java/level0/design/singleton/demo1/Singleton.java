package level0.design.singleton.demo1;

import java.lang.reflect.Constructor;

/**
 * 单例模式：饿汉模式
 * 1. 直接new
 * 2. 静态代码块
 */
public class Singleton {
    private static Singleton singleton1 = new Singleton();
    private static Singleton singleton2;

    // 私有构造器
    private Singleton() {
        System.out.println("Singleton...constructor..");
        if(singleton1 != null){
          //  throw new RuntimeException("不能重复调用");
        }
    }

    static {
        System.out.println("Singleton...static..");
        singleton2 = new Singleton();
    }

    public static Singleton getInstance1() {
        return singleton1;
    }

    public static Singleton getInstance2() {
        return singleton2;
    }


    public static void main(String[] args) {
        try {
            /*
                构造器破解单例模式
             */
            Class<Singleton> clazz = Singleton.class;
            Constructor<Singleton> constructor = clazz.getDeclaredConstructor();
            constructor.setAccessible(true);

            Singleton instance = constructor.newInstance();
            Singleton instance2 = constructor.newInstance();

            System.out.println(instance);
            System.out.println(instance2);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
