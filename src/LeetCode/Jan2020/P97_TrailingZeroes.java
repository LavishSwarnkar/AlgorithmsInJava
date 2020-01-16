package LeetCode.Jan2020;

public class P97_TrailingZeroes {

    public static void main(String args[]){
        System.out.println(trailingZeroes(10));
        System.out.println(trailingZeroes(5));
        System.out.println(trailingZeroes(25));
        System.out.println(trailingZeroes(20));
        System.out.println(trailingZeroes(1808548329));
    }

    public static int trailingZeroes(int n) {
        int count = 0;
        for(long i=5 ; n/i >= 1 ; i*=5)
            count += Math.ceil(n/i);
        return count;
    }

    public static int trailingZeroes2(int n) {
        return (n!=0) ? n/5 + trailingZeroes(n/5) : 0;
    }

}
