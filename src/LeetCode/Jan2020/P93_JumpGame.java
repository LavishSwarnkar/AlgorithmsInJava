package LeetCode.Jan2020;

public class P93_JumpGame {

    public static void main(String args[]){
        /*System.out.println(canJump1(new int[]{2,3,1,1,4}));
        System.out.println(canJump1(new int[]{3,2,1,0,4}));*/

        System.out.println(canJump4(new int[]{2,3,1,1,4}));
        System.out.println(canJump4(new int[]{3,2,1,0,4}));
        System.out.println(canJump4(new int[]{}));
    }

    public static boolean canJump4(int[] nums) {
        if(nums.length == 0)
            return true;
        int lastGoodIndex = nums.length-1;
        for(int i=nums.length-2 ; i>=0 ; i--){
            if(i+nums[i] >= lastGoodIndex)
                lastGoodIndex = i;
        }
        return lastGoodIndex == 0;
    }

    //3. Iterative bottom-up DP solution
    public static boolean canJump3(int[] nums) {
        int[] memo = new int[nums.length];
        memo[nums.length-1] = Index.GOOD.ordinal();

        for(int i=nums.length-2 ; i>=0 ; i--){
            int furthestJump = Math.min(i + nums[i], nums.length-1);
            for(int j=furthestJump ; j>i ; j--){
                if(memo[j] == Index.GOOD.ordinal()){
                    memo[i] = Index.GOOD.ordinal();
                    break;
                }
            }
        }

        return memo[0] == Index.GOOD.ordinal();
    }

    private static boolean canJumpHelper3(int[] nums, int i, int[] memo) {
        if (memo[i] != Index.UNKNOWN.ordinal())
            return memo[i] == Index.GOOD.ordinal();
        int furthestJump = Math.min(i + nums[i], nums.length-1);
        for(int j=furthestJump ; j>i ; j--){
            if (memo[j] == Index.UNKNOWN.ordinal())
                memo[j] = canJumpHelper1(nums, j) ? Index.GOOD.ordinal() : Index.BAD.ordinal();
            if(memo[j] == Index.GOOD.ordinal())
                return true;
        }
        return false;
    }

    //2. Memoized Solution
    public static boolean canJump2(int[] nums) {
        int[] memo = new int[nums.length];
        memo[nums.length-1] = Index.GOOD.ordinal();
        return canJumpHelper2(nums, 0, memo);
    }

    private enum Index{
        UNKNOWN, GOOD, BAD
    }

    private static boolean canJumpHelper2(int[] nums, int i, int[] memo) {
        if (memo[i] != Index.UNKNOWN.ordinal())
            return memo[i] == Index.GOOD.ordinal();
        int furthestJump = Math.min(i + nums[i], nums.length-1);
        for(int j=furthestJump ; j>i ; j--){
            if (memo[j] == Index.UNKNOWN.ordinal())
                memo[j] = canJumpHelper2(nums, j, memo) ? Index.GOOD.ordinal() : Index.BAD.ordinal();
            if(memo[j] == Index.GOOD.ordinal())
                return true;
        }
        return false;
    }

    //Simple recursive solution
    public static boolean canJump1(int[] nums) {
        return canJumpHelper1(nums, 0);
    }

    private static boolean canJumpHelper1(int[] nums, int i) {
        if (i == nums.length-1)
            return true;
        int furthestJump = Math.min(i + nums[i], nums.length-1);
        for(int j=furthestJump ; j>i ; j--)
            if(canJumpHelper1(nums, j))
                return true;
        return false;
    }

}
