package LeetCode.Jan2020;

public class P56_HammingWeight {

    public static void main(String args[]){
        System.out.println(hammingWeight(-3));
    }

    //Alternate way : n&(n-1) flips least significant 1-bit.
    public static int hammingWeight2(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;
    }

    public static int hammingWeight(int n) {
        int count = 0;
        while (n != 0){
            if((n&1) == 1)
                count++;
            n >>>= 1;
        }
        return count;
    }

}
