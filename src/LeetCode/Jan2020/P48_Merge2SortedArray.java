package LeetCode.Jan2020;

import java.util.Arrays;

public class P48_Merge2SortedArray {

    public static void main(String args[]){
        int a[] = {1,2,3,0,0,0};
        merge(a, 3, new int[]{2,2,4}, 3);
        System.out.println(Arrays.toString(a));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int o = nums1.length-1;
        m--; n--;
        while (m != -1 && n != -1)
            nums1[o--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
        while (n != -1)
            nums1[o--] = nums2[n--];
    }

}
