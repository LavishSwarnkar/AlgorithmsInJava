package Miscellaneous;

import java.util.Arrays;

public class P8_QuickSort {

    public static void main(String args[]){
        int[] a = new int[]{111,3,2,44,1,55,6,88};
        quickSort(a);
        System.out.println(Arrays.toString(a));
    }

    private static void quickSort(int[] a){
        quickSortHelper(a, 0, a.length-1);
    }

    private static void quickSortHelper(int[] a, int lo, int hi){
        if(lo < hi){
            int pivotPos = partition(a, lo, hi);
            quickSortHelper(a, lo, pivotPos-1);
            quickSortHelper(a, pivotPos+1, hi);
        }
    }

    private static int partition(int[] a, int lo, int hi){
        int pivot = lo, i=lo, j=hi;
        while (i < j){
            while (i < hi && a[i] <= a[pivot])
                i++;
            while (a[j] > a[pivot])
                j--;
            if(i <= j){
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
            }
        }
        int tmp = a[pivot];
        a[pivot] = a[j];
        a[j] = tmp;
        return j;
    }

}
