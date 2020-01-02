package LeetCode.Jan2020;

public class P34_StringToInteger {

    public static void main(String args[]){
        System.out.println(myAtoi("123"));
        System.out.println(myAtoi("   -42"));
        System.out.println(myAtoi("4193 with words"));
        System.out.println(myAtoi("words and 987"));
        System.out.println(myAtoi("-91283472332"));
        System.out.println(myAtoi("2147483648"));

    }

    public static int myAtoi(String str) {
        char[] chars = str.toCharArray();
        int i=0;
        while (i<chars.length && chars[i] == ' ') i++;
        if(i == chars.length)
            return 0;
        long n = 0;
        boolean isNegative = false;
        if(chars[i] == '-'){
            isNegative = true;
            i++;
        }
        if(i<chars.length && isNegative && chars[i] == '+')
            return 0;
        if(i<chars.length && chars[i] == '+')
            i++;
        while (i<chars.length && chars[i] >= '0' && chars[i] <= '9'){
            n = n*10 + (chars[i] - 48);
            if(n > Integer.MAX_VALUE)
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            i++;
        }
        return isNegative ? (int) -n : (int) n;
    }

}
