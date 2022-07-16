package level0.design.singleton.demo1;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class MainTest {
    public static void main(String[] args) {
        Singleton instance1 = Singleton.getInstance1();
        Singleton instance2 = Singleton.getInstance1();

        Singleton instance21 = Singleton.getInstance2();
        Singleton instance22 = Singleton.getInstance2();

        System.out.println(instance1 == instance2);

        System.out.println(instance21 == instance22);

        System.out.println("AMAC".contains("AMAC"));
        System.out.println("AMAC2".contains("AMAC"));

        JsonElement jsonElement = new JsonParser().parse("");

    }
}
