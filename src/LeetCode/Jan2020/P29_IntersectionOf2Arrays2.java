package LeetCode.Jan2020;

import java.util.*;

public class P29_IntersectionOf2Arrays2 {

    public static void main(String args[]){
        int[] a = new int[]{18,73,59,89,84,84,48,84,54,62,67,27,60,0,61,94,84,55,55,60,76,35,84,28,4,9,86,12,89,41,21,65,33}
        , b = new int[]{54,21,73,84,60,18,62,59,89,89,41,55,27,65,94,61,12,76,35,48,0,60,84,9,28,55,4,67,86,33};
        Arrays.sort(a);
        Arrays.sort(b);

        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        System.out.println();

        System.out.println();
        System.out.println(Arrays.toString(intersect(new int[]{1,2,2,1}, new int[]{2,2})));
        System.out.println(Arrays.toString(intersect(new int[]{4,9,5}, new int[]{9,4,9,8,4})));
    }

    public int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0, j=0, k=0;

        while(i<nums1.length && j<nums2.length){
            if(nums1[i]==nums2[j]){
                nums1[k++]=nums1[i++];
                j++;
            }
            else if(nums1[i]>nums2[j]) j++;
            else i++;
        }

        return Arrays.copyOfRange(nums1,0,k);
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums1){
            if(map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else
                map.put(num, 1);
        }
        List<Integer> res = new ArrayList<>();
        for(int num : nums2){
            if(map.containsKey(num)){
                res.add(num);
                if(map.get(num) == 1)
                    map.remove(num);
                else
                    map.put(num, map.get(num) - 1);
            }
        }
        int i=0;
        int resArr[] = new int[res.size()];
        for(Integer x : res)
            resArr[i++] = x;
        return resArr;
    }

}
