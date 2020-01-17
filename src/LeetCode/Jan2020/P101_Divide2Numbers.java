package LeetCode.Jan2020;

public class P101_Divide2Numbers {

    public static void main(String args[]){
        System.out.println(divide(-2,-2));
    }

    public static int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean positive = (dividend > 0) == (divisor > 0);
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int result = 0;
        for (int i = 31; i >= 0; --i) {
            if ((dividend >>> i) - divisor >= 0) {
                dividend -= divisor << i;
                result += 1 << i;
            }
        }
        return positive ? result : -result;
    }

}
