package LeetCode.Jan2020;

public class P57_MissingNumber {

    public static void main(String args[]){
        System.out.println(missingNumber(new int[]{0,1,3,4}));
    }

    public static int missingNumber(int[] nums) {
        int sum = 0, n = nums.length;
        for(int i : nums)
            sum += i;
        return (n*(n+1))/2 - sum;
    }

}
