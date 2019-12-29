package LeetCode;

public class P3_MaxProductSubArray {

    public static void main(String args[]){
        System.out.println(maxProduct(new int[]{-2, 3, -4}));
    }

    public static int maxProduct(int[] nums) {
        if(nums.length == 0)
            return 0;
        int currMax, currMin, globalMax;
        currMax = currMin = globalMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = currMax;
            currMax = Math.max(Math.max(currMax * nums[i], currMin * nums[i]), nums[i]);
            currMin = Math.min(Math.min(temp * nums[i], currMin * nums[i]), nums[i]);
            if(currMax > globalMax)
                globalMax = currMax;
        }
        return globalMax;
    }

}
