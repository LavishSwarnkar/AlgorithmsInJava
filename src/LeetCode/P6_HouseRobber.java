package LeetCode;

public class P6_HouseRobber {

    public static void main(String args[]){
        System.out.println(rob(new int[]{1,2,3,1}));
        System.out.println(rob(new int[]{2,7,9,3,1}));
        System.out.println(rob(new int[]{2,1,1,2}));
    }

    public static int rob(int[] nums) {
        switch (nums.length){
            case 0 : return 0;
            case 1 : return nums[0];
            case 2 : return Math.max(nums[0], nums[1]);
            default: {
                int a = nums[0], b = Math.max(nums[0], nums[1]);
                for(int i=2 ; i<nums.length ; i++){
                    int t = a;
                    a = b;
                    b = Math.max(b, nums[i] + t);
                }
                return b;
            }
        }
    }

}
