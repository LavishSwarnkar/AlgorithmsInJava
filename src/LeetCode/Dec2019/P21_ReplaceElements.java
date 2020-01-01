package LeetCode.Dec2019;

import java.util.Arrays;

public class P21_ReplaceElements {

    public static void main(String args[]){
        System.out.println(Arrays.toString(replaceElements(new int[]{17,18,5,4,6,1})));
    }

    public static int[] replaceElements(int[] arr) {
        if(arr.length == 0)
            return arr;

        int max = arr[arr.length-1];
        arr[arr.length-1] = -1;
        for(int i=arr.length-2 ; i>=0 ; i--){
            int tmp = arr[i];
            arr[i] = max;
            if(tmp > max)
                max = tmp;
        }
        return arr;
    }

}
