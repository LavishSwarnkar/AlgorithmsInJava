package LeetCode.Jan2020;

public class P100_Sqrt {

    public static void main(String args[]){
        System.out.println(mySqrt(8));
        System.out.println(mySqrt(100));
        System.out.println(mySqrt(2147395599));
    }

    public static int mySqrt(int x) {
        if(x == 1 || x == 0)
            return x;
        long lo = 0, hi = x/2, ans = 0;
        while (lo <= hi){
            long mid = lo + (hi - lo)/2
                    , sq = mid*mid;

            if(sq == x) {
                return (int) mid;
            } else if(sq > x){
                hi = mid-1;
            } else {
                ans = mid;
                lo = mid+1;
            }
        }
        return (int) ans;
    }

}
