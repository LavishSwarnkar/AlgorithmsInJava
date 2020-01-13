package LeetCode.Jan2020;

public class P83_FindKthLargest {

    public static void main(String args[]){
        System.out.println(findKthLargest(new int[]{3,2,4,1,5}, 2));
    }

    public static int findKthLargest(int[] nums, int k) {
        if(nums.length == 0) {
            return 0;
        }
        return qs(nums, nums.length - k, 0, nums.length - 1);
    }

    private static int qs(int[] nums, int k, int st, int ed) {
        if(st == ed) return nums[st];

        int start = st;
        int end = ed;

        int pivot = nums[(st + ed + 1) / 2];

        while(start <= end) {
            while(start <= end && nums[start] < pivot)
                start++;

            while(start <= end && nums[end] > pivot)
                end--;

            if(start <= end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }

        if(k >= start)
            return qs(nums, k, start, ed);
        else if(k <= end)
            return qs(nums, k, st, end);

        return nums[k];
    }

}
