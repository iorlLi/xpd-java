package level0.design.singleton.demo2;

public class MainTest {
    public static void main(String[] args) {
        SingletonY instance = SingletonY.getInstance();
        SingletonY instance2 = SingletonY.getInstance();
        System.out.println(instance == instance2);
        System.out.println(instance2);
        System.out.println(instance);
    }
}
