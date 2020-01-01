package Miscellaneous;

import java.util.Arrays;

public class P2_MovingZeroes {

    public static void main(String args[]){
        System.out.println(Arrays.toString(moveZeroes(new int[]{0, 1, 0, 0, 3, 4, 0})));
        System.out.println(Arrays.toString(moveZeroes(new int[]{10, 1, 3, 4})));

        /* Output :
            [1, 3, 4, 0, 0, 0, 0]
            [10, 1, 3, 4]
         */
    }

    private static int[] moveZeroes(int[] arr){
        int noOfZeroes = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 0){
                noOfZeroes++;
            } else {
                arr[i-noOfZeroes] = arr[i];
            }
        }
        for (int i = arr.length - noOfZeroes; i < arr.length; i++)
            arr[i] = 0;
        return arr;
    }

}
