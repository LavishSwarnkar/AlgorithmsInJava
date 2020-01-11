package Miscellaneous;

import java.util.Arrays;

public class P7_HeapSort {

    public static void main(String args[]){
        int[] a = new int[]{444,3333,21,33,2,1};
        heapSort(a);
        System.out.println(Arrays.toString(a));
    }

    private static void heapSort(int[] a){
        for(int i=1 ; i<a.length ; i++)
            filterUp(a, i);
        for(int i=a.length-1 ; i>0 ; i--){
            swap(a, i, 0);
            filterDown(a, i);
        }
    }

    private static void filterDown(int[] a, int n) {
        int i = 0, l = 1, r = 2;
        while (l<n || r<n){
            int maxChild = l>=n ? r : (r>=n ? l : (a[l] > a[r] ? l : r));
            if(a[maxChild] > a[i]){
                swap(a, maxChild, i);
                i = maxChild;
                l = 2*maxChild+1;
                r = 2*maxChild+2;
            } else {
                break;
            }
        }
    }

    private static void filterUp(int[] a, int i){
        int p = (i-1)/2;
        while (p >= 0 && a[i] > a[p]){
            swap(a, i, p);
            p = (p-1)/2;
        }
    }

    private static void swap(int[] a, int i, int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

}
