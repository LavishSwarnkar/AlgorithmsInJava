package LeetCode.Jan2020;

import java.util.Arrays;

public class P95_LongestIncreasingSubSequence {

    public static void main(String args[]){
        new Solution().lengthOfLIS(new int[]{0,8,4,12,2});
    }

    public static class Solution {
        int lengthOfLIS(int[] nums) {
            int[] dp = new int[nums.length];
            int len = 0;
            for (int num : nums) {
                int i = Arrays.binarySearch(dp, 0, len, num);
                if (i < 0) {
                    i = -(i + 1);
                }
                dp[i] = num;
                if (i == len) {
                    len++;
                }
            }
            return len;
        }
    }

    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0)
            return 0;
        int[] lengths = new int[nums.length];
        Arrays.fill(lengths, 1);

        int maxSoFar = 1;

        for(int i=1 ; i<nums.length ; i++){
            for(int j=0 ; j<i ; j++){
                if(nums[i] > nums[j]){
                    lengths[i] = Math.max(lengths[i], lengths[j]+1);
                }
            }
            maxSoFar = Math.max(maxSoFar, lengths[i]);
        }

        return maxSoFar;
    }

}
