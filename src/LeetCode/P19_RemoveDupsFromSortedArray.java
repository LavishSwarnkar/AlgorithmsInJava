package LeetCode;

import java.util.Arrays;

public class P19_RemoveDupsFromSortedArray {

    public static void main(String args[]){
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums) + " " + Arrays.toString(nums));

        nums = new int[]{1,1,2};
        System.out.println(removeDuplicates(nums) + " " + Arrays.toString(nums));
    }

    public static int removeDuplicates(int[] nums) {
        int i=0, shiftFactor = 0;
        while (i < nums.length){
            while (i < nums.length-1 && nums[i] == nums[i+1]){
                i++;
                shiftFactor++;
            }
            if(++i < nums.length && shiftFactor > 0)
                nums[i-shiftFactor] = nums[i];
        }
        return nums.length - shiftFactor;
    }

}
