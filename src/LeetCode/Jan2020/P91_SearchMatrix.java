package LeetCode.Jan2020;

public class P91_SearchMatrix {

    public static void main(String args[]){
        System.out.println(searchMatrix(new int[][]{
                {1,3,5,7},{10,11,16,20},{23,30,34,50}}, 51));
        System.out.println(searchMatrix(new int[][]{
                {1}}, 0));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0)
            return false;
        int lo = 0, hi = matrix.length-1;
        while (lo <= hi){
            int mid = lo + (hi-lo)/2;
            if(target >= matrix[mid][0] && target <= matrix[mid][matrix[mid].length-1])
                return binSearch(matrix[mid], target, 0, matrix[mid].length-1);
            else if(target < matrix[mid][0])
                hi = mid-1;
            else
                lo = mid+1;
        }
        return false;
    }

    private static boolean binSearch(int[] nums, int target, int lo, int hi){
        while (lo < hi){
            int mid = lo + (hi-lo)/2;
            if(nums[mid] == target)
                return true;
            else if(nums[mid] > target)
                hi = mid-1;
            else
                lo = mid+1;
        }
        return lo == hi && nums[lo] == target;
    }

}
