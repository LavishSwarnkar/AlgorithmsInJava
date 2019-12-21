import java.util.Arrays;

public class P1_MatrixSpiralTraversal {

    public static void main(String args[]){
        check(3,4,5,6);
    }

    private static int[][] getSpiralSquareMatrix(int n){
        int[][] matrix = new int[n][n];
        int count = 1;

        for(int i=0 ; i<Math.ceil(n/2f) ; i++){
            for(int j=i ; j<n-i ; j++)
                matrix[i][j] = count++;
            for(int j=1+i ; j<n-i ; j++)
                matrix[j][n-i-1] = count++;
            for(int j=n-i-2 ; j>=i ; j--)
                matrix[n-i-1][j] = count++;
            for(int j=n-i-2 ; j>i ; j--)
                matrix[j][i] = count++;
        }
        return matrix;
    }

    private static void check(int... ns){
        for(int n: ns){
            System.out.println(String.format("IN : %d", n));
            System.out.println(String.format("OUT : %s", getMatrixString(getSpiralSquareMatrix(n))));
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
