package level0.java8.lambda;

import org.apache.commons.lang3.StringUtils;

import java.util.function.*;

/**
 * 内置接口
 */
public class LambdaTest1 {
    public static String testConsumer(String str, Consumer<String> consumer) {
        consumer.accept(str);
        return str;
    }

    public static String test2(String str, Supplier<String> supplier) {
        String s = supplier.get();
        return str.concat(s);
    }

    public static String test2(String a, String b, Function<String, Integer> function) {
        BinaryOperator<String> operator = String::concat;
        String apply1 = operator.apply(a, b);
        System.out.println(apply1);
        Integer apply = function.apply(a);
        return a.substring(apply/2);
    }

    public static String test3(String str, Predicate<String> predicate) {
        if (predicate.test(str)) {
            str = str.substring(5);
        }
        return str;
    }

    public static void main(String[] args) {
        String test1 = testConsumer("abc", String::toUpperCase);
        System.out.println(test1);
        String test2 = test2("abc", () -> String.valueOf(Math.random()));
        System.out.println(test2);

        String test3 = test3("abc", a -> a.length() > 5);
        System.out.println(test3);

        String test21 = test2("abc", "*", String::length);
        System.out.println(test21);
    }
}
