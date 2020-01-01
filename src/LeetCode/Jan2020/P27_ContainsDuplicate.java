package LeetCode.Jan2020;

import java.util.HashSet;
import java.util.Set;

public class P27_ContainsDuplicate {

    public static void main(String args[]){
        System.out.println(containsDuplicate(new int[]{1,2,3,1}));
        System.out.println(containsDuplicate(new int[]{1,2,3,4}));
    }

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> nums2 = new HashSet<>();
        for(int num : nums){
            if(nums2.contains(num))
                return true;
            nums2.add(num);
        }
        return false;
    }

}
