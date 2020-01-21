package LeetCode.Jan2020;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P105_MajorityElement {

    public static void main(String args[]){
        System.out.println(majorityElement3(new int[]{2,1,2,4,7}));
    }

    public static int majorityElement3(int[] nums) {
        int major = nums[0];
        int count = 1;
        for (int i=1; i < nums.length; i++) {
            if (nums[i] != major) {
                count--;
            } else {
                count++;
            }
            if (count == 0) {
                major = nums[i];
                count = 1;
            }
        }
        return major;
    }

    //Boyer Moore Voting Algorithm O(n, 1)
    public static int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }

    //Using Sorting : O(n log(n), 1)
    public static int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    //Using HashMap : O(n, n)
    public static int majorityElement1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Integer maj = null;
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
            if(maj == null || map.get(num) > map.get(maj))
                maj = num;
        }
        return maj == null ? -1 : maj;
    }

}
