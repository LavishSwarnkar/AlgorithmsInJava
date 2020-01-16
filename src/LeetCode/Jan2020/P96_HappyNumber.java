package LeetCode.Jan2020;

public class P96_HappyNumber {

    public static void main(String args[]){
        System.out.println(isHappy(19));
        System.out.println(isHappy(23));
        System.out.println(isHappy(24));
    }

    public static boolean isHappy(int n) {
        if(n == 0)
            return false;
        int sum = getSum(n);
        while (sum != 1 && sum != 4){
            sum = getSum(sum);
        }
        return sum == 1;
    }

    private static int getSum(int n){
        int sum = 0, rem;
        while (n > 0){
            rem = n%10;
            sum += rem*rem;
            n /= 10;
        }
        return sum;
    }

}
