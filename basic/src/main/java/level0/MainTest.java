package level0;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class MainTest {
    public static void main(String[] args) {
        String str1 = "string";
        String str2 = "buffer";
        System.out.println(str1 + str2) ;

        StringBuffer stringBuffer = new StringBuffer(str1);
        stringBuffer.append(str1).append(str2);
        System.out.println(stringBuffer.toString());
    }
}
