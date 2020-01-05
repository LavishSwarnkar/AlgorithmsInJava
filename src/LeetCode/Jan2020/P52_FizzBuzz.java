package LeetCode.Jan2020;

import java.util.ArrayList;
import java.util.List;

public class P52_FizzBuzz {

    public static void main(String args[]){
        System.out.println(fizzBuzz(15));
    }

    public static List<String> fizzBuzz(int n) {
        List<String> strings = new ArrayList<>();
        int m3 = 1, m5 = 1;
        for(int i=1 ; i<=n ; i++, m3++, m5++) {
            if (m3 == 3 && m5 == 5) {
                strings.add("FizzBuzz");
                m3 = m5 = 0;
            } else if (m3 == 3) {
                strings.add("Fizz");
                m3 = 0;
            } else if (m5 == 5) {
                strings.add("Buzz");
                m5 = 0;
            } else {
                strings.add(i + "");
            }
        }
        return strings;
    }

}
