package LeetCode.Dec2019;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P1_TwoSum {

    public static void main(String args[]){
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[]{11, 15, 2, 7}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[]{2, 11, 15, 22, 7}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[]{2, 11, 15, 22, 8}, 9)));
    }

    private static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numIndexMap = new HashMap<>();
        for(int i=0 ; i<nums.length ; i++){
            if(numIndexMap.containsKey(target - nums[i]))
                return new int[]{numIndexMap.get(target - nums[i]), i};
            numIndexMap.put(nums[i], i);
        }
        return null;
    }

}