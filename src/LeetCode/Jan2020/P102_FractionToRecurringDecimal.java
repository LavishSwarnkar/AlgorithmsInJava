package LeetCode.Jan2020;

import java.util.HashMap;
import java.util.Map;

public class P102_FractionToRecurringDecimal {

    public static void main(String args[]){
        System.out.println(fractionToDecimal(-1, -2147483648));
    }

    public static String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0)
            return "0";
        StringBuilder builder = new StringBuilder();
        if (!(numerator>0 == denominator>0))
            builder.append("-");

        long a = Math.abs((long) numerator)
                , b = Math.abs((long) denominator);

        builder.append(a / b);

        long rem = a % b;

        if(rem == 0)
            return builder.toString();

        builder.append(".");
        Map<Long, Integer> map = new HashMap<>();
        while (rem != 0){
            if(map.containsKey(rem)){
                builder.insert(map.get(rem), "(").append(")");
                break;
            }
            map.put(rem, builder.length());
            rem *= 10;
            builder.append(rem / b);
            rem %= b;
        }
        return builder.toString();
    }

}
