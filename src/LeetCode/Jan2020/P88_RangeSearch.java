package LeetCode.Jan2020;

import java.util.Arrays;

public class P88_RangeSearch {

    public static void main(String args[]){
        /*System.out.println(Arrays.toString(searchRange(new int[]{5,8,8,8,8,10}, 8)));
        System.out.println(Arrays.toString(searchRange(new int[]{1}, 1)));
        System.out.println(Arrays.toString(searchRange(new int[]{1,2,3,3,3,3,4,5,9}, 3)));
        System.out.println(Arrays.toString(searchRange(new int[]{5,7,7,8,8,10}, 6)));*/
        System.out.println(Arrays.toString(searchRange(new int[]{0,0,1,1,1,2,4,4,4,4,5,5,5,6,8,8,9,9,10,10,10}, 8)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int lo = 0, hi = nums.length-1;
        while (lo <= hi){
            int mid = (lo + hi)/2;
            if(nums[mid] == target){
                int start = getLeftMostOcc(nums, target, lo, mid)
                        , end = getRightMostOcc(nums, target, mid+1, hi);
                return new int[]{start == -1 ? mid : start, end == -1 ? mid : end};
            } else if(nums[mid] < target){
                lo = mid+1;
            } else {
                hi = mid;
            }
            if(lo == hi)
                return nums[lo] == target ? new int[]{lo, lo} : new int[]{-1, -1};
        }
        return new int[]{-1, -1};
    }

    private static int getLeftMostOcc(int[] nums, int target, int lo, int hi){
        if(lo == hi && nums[lo] == target)
            return lo;
        if(lo < hi){
            int mid = (lo + hi)/2;
            if(nums[mid] == target){
                int ans = getLeftMostOcc(nums, target, lo, mid);
                return ans == -1 ? mid : ans;
            } else if(nums[mid] > target){
                return getLeftMostOcc(nums, target, lo, mid);
            } else {
                return getLeftMostOcc(nums, target, mid+1, hi);
            }
        }
        return -1;
    }

    private static int getRightMostOcc(int[] nums, int target, int lo, int hi){
        if(lo == hi && nums[lo] == target)
            return lo;
        if(lo < hi){
            int mid = (lo + hi)/2;
            if(nums[mid] == target){
                int ans = getRightMostOcc(nums, target, mid+1, hi);
                return ans == -1 ? mid : ans;
            } else if(nums[mid] > target){
                return getRightMostOcc(nums, target, lo, mid);
            } else {
                return getRightMostOcc(nums, target, mid+1, hi);
            }
        }
        return -1;
    }

}
