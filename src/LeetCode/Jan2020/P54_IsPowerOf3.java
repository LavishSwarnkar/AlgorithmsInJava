package LeetCode.Jan2020;

public class P54_IsPowerOf3 {

    public static void main(String args[]){
        System.out.println(isPowerOfThree2(25));
    }

    public static boolean isPowerOfThree2(int n) {
        return n!=0 && 1162261467%n == 0;
    }

    public static boolean isPowerOfThree(int n) {
        if(n == 0)
            return false;
        while (n%3 == 0){
            n /= 3;
        }
        return n == 1;
    }

}
