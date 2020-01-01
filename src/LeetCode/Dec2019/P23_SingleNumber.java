package LeetCode.Dec2019;

import java.util.HashMap;
import java.util.Map;

public class P23_SingleNumber {

    public static void main(String args[]){
        System.out.println(singleNumber2(new int[]{4,1,2,1,2}));
    }

    public static int singleNumber2(int[] nums) {
        int single = 0;
        for(int x : nums)
            single ^= x;
        return single;
    }

    public static int singleNumber(int[] nums) {
        Map<Integer, Byte> map = new HashMap<>();
        for(int n : nums){
            if(map.containsKey(n)){
                map.remove(n);
            } else {
                map.put(n, Byte.MAX_VALUE);
            }
        }
        return (int) map.keySet().toArray()[0];
    }

}
