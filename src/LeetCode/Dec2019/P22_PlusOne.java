package LeetCode.Dec2019;

import java.util.Arrays;

public class P22_PlusOne {

    public static void main(String args[]){
        System.out.println(Arrays.toString(plusOne(new int[]{4,3,2,1})));
        System.out.println(Arrays.toString(plusOne(new int[]{9,9,9})));
    }

    public static int[] plusOne(int[] digits) {
        int carry = 1, i=digits.length-1;
        while (carry != 0){
            if(digits[i] == 9){
                digits[i] = 0;
            } else {
                digits[i]++;
                carry = 0;
            }
            if(--i == -1)
                break;
        }
        if(carry == 1){
            int digits2[] = new int[digits.length + 1];
            digits2[0] = 1;
            for(i=0 ; i<digits.length ; i++)
                digits2[i+1] = digits[i];
            digits = digits2;
        }
        return digits;
    }

}
