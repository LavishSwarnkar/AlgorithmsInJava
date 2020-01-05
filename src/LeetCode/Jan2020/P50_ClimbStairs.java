package LeetCode.Jan2020;

public class P50_ClimbStairs {

    public static void main(String args[]){
        System.out.println(climbStairs2(4));
    }

    public static int climbStairs2(int n) {
        if(n == 1)
            return 1;
        int a=1, b=2, c=2;
        for(int i=3 ; i<=n ; i++){
            c = a+b;
            a = b;
            b = c;
        }
        return c;
    }

    //Recursive
    public static int climbStairs(int n) {
        return climbStairs(n, new int[n+1]);
    }

    private static int climbStairs(int n, int[] dp){
        if(n == 1 || n == 2)
            return n;
        if(dp[n] > 0)
            dp[n] = climbStairs(n-1) + climbStairs(n-2);
        return dp[n];
    }

}
