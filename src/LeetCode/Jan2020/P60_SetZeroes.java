package LeetCode.Jan2020;

import java.util.Arrays;

public class P60_SetZeroes {

    public static void main(String args[]){
        int a[][] = {
                {0,1,2,0},
                {3,4,5,2},
                {1,3,1,5}
        }, b[][] = {
                {1}
        };
        setZeroes(a);
        setZeroes(b);
        System.out.println(getMatrixString(a));
    }

    public static void setZeroes(int[][] matrix) {
        int r = -1, c = -1;
        for(int i=0 ; i<matrix.length ; i++){
            for(int j=0 ; j<matrix[0].length ; j++){
                if(matrix[i][j] == 0){
                    if(r == -1){
                        r = i;
                        c = j;
                        continue;
                    }
                    matrix[r][j] = matrix[i][c] = 0;
                }
            }
        }
        if(r != -1){
            for(int i=0 ; i<matrix.length ; i++)
                if(matrix[i][c] == 0 && i != r)
                    for(int j=0 ; j<matrix[0].length ; j++)
                        matrix[i][j] = 0;
            for(int i=0 ; i<matrix[0].length ; i++)
                if(matrix[r][i] == 0 && i != c)
                    for(int j=0 ; j<matrix.length ; j++)
                        matrix[j][i] = 0;
            for(int j=0 ; j<matrix[0].length ; j++)
                matrix[r][j] = 0;
            for(int j=0 ; j<matrix.length ; j++)
                matrix[j][c] = 0;
        }
    }

    private static String getMatrixString(int a[][]){
        StringBuilder builder = new StringBuilder();
        builder.append("\n[\n ");
        for (int[] row : a)
            builder.append(Arrays.toString(row)).append(",\n ");
        builder.delete(builder.length()-3, builder.length());
        return builder.append("\n]").toString();
    }

}
