package LeetCode.Jan2020;

import java.util.Arrays;

public class P30_ReverseString {

    public static void main(String args[]){
        char[] s = "".toCharArray();
        reverseString(s);
        System.out.println(Arrays.toString(s));
    }

    public static void reverseString(char[] s) {
        for(int i=0 ; i<s.length/2 ; i++){
            char tmp = s[i];
            s[i] = s[s.length-1-i];
            s[s.length-1-i] = tmp;
        }
    }

}
