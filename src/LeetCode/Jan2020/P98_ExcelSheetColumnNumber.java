package LeetCode.Jan2020;

public class P98_ExcelSheetColumnNumber {

    public static void main(String args[]){
        System.out.println(titleToNumber("A"));
        System.out.println(titleToNumber("B"));
        System.out.println(titleToNumber("ZA"));
        System.out.println(titleToNumber("AAB"));
    }

    public static int titleToNumber(String s) {
        char[] chars = s.toCharArray();
        int n = 0;
        for(int i=chars.length-1 ; i>=0 ; i--)
            n += Math.pow(26, chars.length-1-i) * (chars[i] - 'A' + 1);
        return n;
    }

}
