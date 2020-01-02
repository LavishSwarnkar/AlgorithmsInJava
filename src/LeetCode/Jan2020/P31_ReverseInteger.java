package LeetCode.Jan2020;

public class P31_ReverseInteger {

    public static void main(String args[]){
        System.out.println(reverse(1534236469));
    }

    public static int reverse(int x) {
        int xCopy = x;
        long n = 0;
        x = Math.abs(x);
        while (x > 0){
            n = n*10 + x%10;
            if(n > Integer.MAX_VALUE)
                return 0;
            x /= 10;
        }
        return xCopy<0 ? (int) -n : (int) n;
    }

}
