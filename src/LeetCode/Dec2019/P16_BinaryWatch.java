package LeetCode.Dec2019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P16_BinaryWatch {

    public static void main(String args[]){
        System.out.println(readBinaryWatch(1));
    }

    public static ArrayList<String> readBinaryWatch(int num) {
        ArrayList<String> ans = new ArrayList<>();
        for (int i=0 ; i<12 ; i++) {
            for (int j = 0; j < 60; j++){
                if (bitCount(i) + bitCount(j) == num)
                    ans.add(String.format("%d:%02d", i, j));
            }
        }
        return ans;
    }

    private static int bitCount(int num) {
        int result = 0;
        while (num > 0) {
            if (num%2 == 1)
                result++;
            num /= 2;
        }
        return result;
    }

}
