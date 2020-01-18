package LeetCode.Jan2020;

public class P103_SumOf2Integers {

    public static void main(String args[]){
        System.out.println(getSum(1, 2));
        System.out.println(getSum(100, 21));
        System.out.println(getSum(11, 3));
        System.out.println(getSum(-2, 3));
        System.out.println(getSum(3, -2));
        System.out.println(getSum(4, -100));
    }

    public static int getSum(int a, int b) {
        int carry;
        while (b != 0){
            carry = a&b;
            a ^= b;
            b = carry<<1;
        }
        return a;
    }

}
