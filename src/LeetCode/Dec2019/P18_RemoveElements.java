package LeetCode.Dec2019;

import java.util.Arrays;

public class P18_RemoveElements {

    public static void main(String args[]){
        int[] nums = new int[]{0,1,2,2,3,0,4,2};
        System.out.println(removeElement(nums, 2) + " " + Arrays.toString(nums));
    }

    public static int removeElement(int[] nums, int val) {
        int noOfOcc = 0;
        for(int i=0 ; i<nums.length ; i++){
            if(nums[i] == val){
                noOfOcc++;
                continue;
            }
            if(noOfOcc > 0)
                nums[i - noOfOcc] = nums[i];
        }
        return nums.length - noOfOcc;
    }

}
