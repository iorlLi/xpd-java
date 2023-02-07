package java8;

import level0.java8.lambda.MyFunction;
import org.junit.Test;

public class Test1 {
    @Test
    public void test01(){
        String str = method1("apple", String::toUpperCase);
        System.out.println(str);

    }
    static String method1(String str, MyFunction myFunction){
        return myFunction.getValue(str);
    }
}
