package LeetCode.Jan2020;

public class P80_SortColors {

    public static void main(String args[]){

    }

    public void sortColors(int[] nums) {
        if(nums.length <= 1)
            return;

        int index = 0, start = 0, end = nums.length-1;
        while (index < end && start < end){
            if(nums[index] == 0){
                nums[index++] = nums[start];
                nums[start++] = 0;
            } else if(nums[index] == 2){
                nums[index] = nums[end];
                nums[end--] = 2;
            } else {
                index++;
            }
        }
    }

}
