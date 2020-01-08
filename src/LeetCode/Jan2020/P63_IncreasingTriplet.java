package LeetCode.Jan2020;

public class P63_IncreasingTriplet {

    public static void main(String args[]){
        System.out.println(increasingTriplet(new int[]{5,1,5}));
        System.out.println(increasingTriplet(new int[]{5,4,3,2,1}));
        System.out.println(increasingTriplet(new int[]{1,2,3}));
        System.out.println(increasingTriplet(new int[]{1,2}));
    }

    public static boolean increasingTriplet(int[] nums) {
        int c1 = Integer.MAX_VALUE, c2 = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= c1)
                c1 = num;
            else if (num <= c2)
                c2 = num;
            if (num > c2)
                return true;
        }
        return false;
    }

    public static boolean increasingTriplet2(int[] nums) {
        for(int i=1 ; i<nums.length-1 ; i++)
            if(nums[i-1] < nums[i] && nums[i] < nums[i+1])
                return true;
        return false;
    }

}
