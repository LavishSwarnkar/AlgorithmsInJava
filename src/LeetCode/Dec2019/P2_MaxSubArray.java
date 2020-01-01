package LeetCode.Dec2019;

public class P2_MaxSubArray {

    public static void main(String args[]){
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

    public static int maxSubArray(int[] nums) {
        if(nums.length == 0)
            return 0;
        int currSum, globalSum;
        currSum = globalSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currSum = Math.max(nums[i] + currSum, nums[i]);
            if(currSum > globalSum)
                globalSum = currSum;
        }
        return globalSum;
    }

}
