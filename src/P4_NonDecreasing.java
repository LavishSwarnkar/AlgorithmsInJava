public class P4_NonDecreasing {

    public static void main(String args[]){
        System.out.println(isNonDecreasingPossible(new int[]{4, 2, 3}));
        System.out.println(isNonDecreasingPossible(new int[]{4, 2, 1}));
        System.out.println(isNonDecreasingPossible(new int[]{3, 4, 2, 3}));
        System.out.println(isNonDecreasingPossible(new int[]{2, 3, 3, 2, 4}));
    }

    private static boolean isNonDecreasingPossible(int[] nums){
        int r = -1;
        for(int i=0 ; i<nums.length-1 ; i++){
            if(nums[i] > nums[i+1]){
                if(r > -1)
                    return false;
                r = i;
            }
        }
        try {
            return (r == 0
                    || r == nums.length-2
                    || nums[r-1] <= nums[r+1]
                    || nums[r] <= nums[r+2]);
        } catch (Exception e){
            return true;
        }
    }

}
