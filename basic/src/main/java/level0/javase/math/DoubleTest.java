package level0.javase.math;

import java.text.DecimalFormat;

public class DoubleTest {
    public static void main(String[] args) {
        Double d1 = (double) 0;
        Double d2 = null;
        DecimalFormat format = new DecimalFormat("######0.00");
        String format1 = format.format(d1);
        //String format2 = format.format(d2);
        System.out.println(format1);
        System.out.println(d1);

        Double d3 = 1000.9010;
        int i = d3.intValue();
        System.out.println(i);

        //NumberUtils.toScaledBigDecimal();
    }
}
