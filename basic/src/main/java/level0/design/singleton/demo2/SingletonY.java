package level0.design.singleton.demo2;

import java.io.*;

/**
 * 静态内部类: 外部类加载时并不去加载内部类
 * 此实现中，访问内部类的静态变量，执行初始化，才会加载此静态类。
 * 既有懒加载的优势
 */
public class SingletonY implements Serializable {

    private SingletonY() {

    }

    public static SingletonY getInstance() {
        return SingletonYHolder.INSTANCE;
    }

    static class SingletonYHolder {
        private static SingletonY INSTANCE = new SingletonY();
    }

    /*
     * 序列化会破环单例模式：像文件中写入一个对象，再多次读取该对象，对象的地址会不一样。
     *
     */
    public Object readResolve() {
        return SingletonYHolder.INSTANCE;
    }

    static String path = "C:\\Users\\86166\\Desktop\\b.txt";

    public static void main(String[] args) {
       // write();

        read();
        read();
    }

    /*

     */
    private static void read() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            Object instance1 = ois.readObject();
            System.out.println(instance1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * 修改代码要重写一次文件
     */
    private static void write() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(SingletonY.getInstance());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
