package LeetCode.Dec2019;

import java.util.Arrays;

public class P25_RotateArray {

    public static void main(String args[]){

        int a[] = {1,2,3,4,5,6,7,8,9};
        rotate(a, 2);
        System.out.println(Arrays.toString(a));
        a = new int[]{1,2,3,4};
        rotate(a, 2);
        System.out.println(Arrays.toString(a));
        a = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27};
        rotate(a, 38);
        System.out.println(Arrays.toString(a));
    }

    public static void rotate(int[] nums, int k) {
        k %= nums.length;
        k = nums.length - k;
        if(k == 0)
            return;
        for (int i=0 ; i<gcd(nums.length, k) ; i++){
            int j=i, tmp = nums[i], d;
            while (true){
                d = (j+k)%nums.length;
                if(d == i)
                    break;
                nums[j] = nums[d];
                j = d;
            }
            nums[j] = tmp;
        }
    }

    public static void rotateL(int[] nums, int k) {
        int n = nums.length;
        k = k%n;
        if(k==0)
            return;
        if (k <= n/2){
            for(int i=0 ; i<n/k ; i++){
                for(int j=n-k ; j<n ; j++){
                    int tmp = nums[j];
                    nums[j] = nums[j-(n-k)+(i*k)];
                    nums[j-(n-k)+(i*k)] = tmp;
                }
            }
        } else {
            for(int i=0 ; n-i*(n-k)>(n-k) ; i++){
                for(int j=n-k-1 ; j>=0 ; j--){
                    int tmp = nums[j];
                    nums[j] = nums[j+k-i*(n-k)];
                    nums[j+k-i*(n-k)] = tmp;
                }
            }
        }
    }

    private static int gcd(int a, int b){
        while (a != b) {
            if(a > b)
                a -= b;
            else
                b -= a;
        }
        return a;
    }

}
