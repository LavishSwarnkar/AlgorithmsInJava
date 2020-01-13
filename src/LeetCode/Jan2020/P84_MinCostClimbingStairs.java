package LeetCode.Jan2020;

import java.util.Arrays;

public class P84_MinCostClimbingStairs {

    public static void main(String args[]){
        System.out.println(minCostClimbingStairs4(new int[]{}));
        System.out.println(minCostClimbingStairs4(new int[]{10}));
        System.out.println(minCostClimbingStairs4(new int[]{10, 15}));
        System.out.println(minCostClimbingStairs4(new int[]{10, 15, 20}));
        System.out.println(minCostClimbingStairs4(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }

    //4. Reduced space Iterative Solution
    public static int minCostClimbingStairs4(int[] cost) {
        if(cost.length <= 1)
            return cost.length == 1 ? cost[0] : 0;
        int a = cost[0], b = cost[1], c;
        for(int i=2 ; i<cost.length ; i++){
            c = Math.min(a, b) + cost[i];
            a = b;
            b = c;
        }
        return Math.min(a, b);
    }

    //3. Iterative Solution
    public static int minCostClimbingStairs3(int[] cost) {
        if(cost.length <= 1)
            return cost.length == 1 ? cost[0] : 0;
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for(int i=2 ; i<cost.length ; i++)
            dp[i] = Math.min(dp[i-1], dp[i-2]) + cost[i];
        return Math.min(dp[cost.length-1], dp[cost.length-2]);
    }

    //2. Memoized Recursive Solution
    public static int minCostClimbingStairs2(int[] cost) {
        int[] dp = new int[cost.length+1];
        Arrays.fill(dp, -1);
        return minCost2(cost, cost.length, dp);
    }

    private static int minCost2(int[] cost, int i, int[] dp){
        if(i == 0 || i == 1)
            return cost[i];
        if(dp[i] == -1)
            dp[i] = Math.min(minCost2(cost, i-1, dp), minCost2(cost, i-2, dp))
                    + ((i == cost.length) ? 0 : cost[i]);
        return dp[i];
    }

    //1. Simple Recursive Solution
    public static int minCostClimbingStairs1(int[] cost) {
        return minCost1(cost, cost.length);
    }

    private static int minCost1(int[] cost, int i){
        if(i == 0 || i == 1)
            return cost[i];
        return Math.min(minCost1(cost, i-1), minCost1(cost, i-2))
                + ((i == cost.length) ? 0 : cost[i]);
    }

}
