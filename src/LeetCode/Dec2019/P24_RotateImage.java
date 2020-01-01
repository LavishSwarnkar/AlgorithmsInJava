package LeetCode.Dec2019;

import java.util.Arrays;

public class P24_RotateImage {

    public static void main(String args[]){
        int a[][] = {{1, 2, 3}
                , {4, 5, 6}
                , {7, 8, 9}}
                , b[][] = {
                  {1 , 2 , 3 , 4}
                , {5 , 6 , 7 , 8}
                , {9 , 10, 11, 12}
                , {13, 14, 15, 16}};
        rotate(a);
        rotate(b);
        System.out.println(getMatrixString(a));
        System.out.println(getMatrixString(b));
    }

    public static void rotate(int[][] in) {
        int lvl = 0, maxLvl = in.length/2, width = in.length-1;
        while (lvl < maxLvl){
            for(int i=lvl ; i<width ; i++){
                int tmp = in[lvl][i];
                in[lvl][i] = in[i][width];
                in[i][width] = tmp;

                tmp = in[lvl][i];
                in[lvl][i] = in[width][width-i+lvl];
                in[width][width-i+lvl] = tmp;

                tmp = in[lvl][i];
                in[lvl][i] = in[width-i+lvl][lvl];
                in[width-i+lvl][lvl] = tmp;
            }
            lvl++;
            width--;
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
