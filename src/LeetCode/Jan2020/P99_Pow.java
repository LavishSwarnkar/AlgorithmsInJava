package LeetCode.Jan2020;

public class P99_Pow {

    public static void main(String args[]){
        System.out.println(myPow(2.1, 2));
        System.out.println(myPow(2.1, -2));
    }

    public static double myPow(double x, int n) {
        if(n == 0) {
            return 1;
        } else {
            int rem = n%2;
            if(rem == 0){
                double r = myPow(x, n/2);
                return r*r;
            } else if(rem == 1){
                return x * myPow(x, n-1);
            } else {
                return (1.0/x) * myPow(x, n+1);
            }
        }
    }

}
