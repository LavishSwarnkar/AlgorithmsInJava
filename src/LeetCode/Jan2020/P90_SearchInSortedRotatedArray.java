package LeetCode.Jan2020;

public class P90_SearchInSortedRotatedArray {

    public static void main(String args[]){
        System.out.println(search(new int[]{1}, 1));
    }

    public static int search(int[] nums, int target) {
        if(nums.length == 0) return -1;

        int lo = 0, hi = nums.length-1;
        while (lo < hi){
            int mid = lo + (hi-lo)/2;
            if(nums[mid] > nums[hi])
                lo = mid+1;
            else
                hi = mid;
        }

        if(target >= nums[lo] && target <= nums[nums.length-1])
            return binSearch(nums, target, lo, nums.length-1);
        return binSearch(nums, target, 0, lo-1);
    }

    private static int binSearch(int[] nums, int target, int lo, int hi){
        while (lo < hi){
            int mid = lo + (hi-lo)/2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] > target)
                hi = mid;
            else
                lo = mid+1;
        }
        return lo == hi && nums[lo] == target ? lo : -1;
    }

}
