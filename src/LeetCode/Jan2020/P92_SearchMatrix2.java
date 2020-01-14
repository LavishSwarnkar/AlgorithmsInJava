package LeetCode.Jan2020;

public class P92_SearchMatrix2 {

    public static void main(String args[]){

    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int rows = matrix.length, cols = matrix[0].length;
        int i = rows-1, j = 0;
        while (i >= 0 && j < cols){
            int val = matrix[i][j];
            if(val == target)
                return true;
            else if(val > target)
                i--;
            else
                j++;
        }
        return false;
    }

}
