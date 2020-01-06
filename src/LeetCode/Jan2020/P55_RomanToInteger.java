package LeetCode.Jan2020;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P55_RomanToInteger {

    public static void main(String args[]){
        System.out.println(romanToInt("MDCCCLXXXIV"));
    }

    //3ms Solution
    public int romanToInt2(String s) {
        if (s == null || s.length() == 0) return 0;
        char prev = ' ';
        int number = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            number = getNumber(number, prev, c);
            prev = c;
        }

        return number;
    }

    private int getNumber(int number, char prev, char current) {
        if (prev == 'I' && current == 'V') return number - 1 + 4;
        if (prev == 'I' && current == 'X') return number - 1 + 9;
        if (prev == 'X' && current == 'L') return number - 10 + 40;
        if (prev == 'X' && current == 'C') return number - 10 + 90;
        if (prev == 'C' && current == 'D') return number - 100 + 400;
        if (prev == 'C' && current == 'M') return number - 100 + 900;
        if (current == 'I') return number + 1;
        if (current == 'V') return number + 5;
        if (current == 'X') return number + 10;
        if (current == 'L') return number + 50;
        if (current == 'C') return number + 100;
        if (current == 'D') return number + 500;
        if (current == 'M') return number + 1000;
        return number;
    }

    public static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        List<Integer> vals = new ArrayList<>();
        int i=0;
        char[] chars = s.toCharArray();
        while (i<chars.length){
            int val = map.get(chars[i++]), charVal = val;
            while (i<chars.length-1 && chars[i] == chars[i-1]){
                i++;
                val += charVal;
            }
            vals.add(val);
        }

        int num = 0;
        for(i=0 ; i<vals.size() ; i++){
            if(i < vals.size()-1 && vals.get(i) < vals.get(i+1))
                num += -vals.get(i);
            else
                num += vals.get(i);
        }

        return num;
    }

}
