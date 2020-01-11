package LeetCode.Jan2020;

import java.util.ArrayList;
import java.util.List;

public class P76_GenerateParentheses {

    public static void main(String args[]){
        System.out.println(generateParenthesis(5));
    }

    private static int count = 0;

    public static List<String> generateParenthesis(int count) {
        char[] str = new char[count*2];
        List<String> perms = new ArrayList<>();
        addParen(str, count, count, 0, perms);
        return perms;
    }

    private static void addParen(char[] str, int leftRem, int rightRem, int index, List<String> perms){
        count++;
        if(leftRem < 0 || rightRem < leftRem) return;
        if(leftRem == 0 && rightRem == 0) {
            perms.add(String.valueOf(str));
        } else {
            str[index] = '(';
            addParen(str, leftRem-1, rightRem, index+1, perms);
            str[index] = ')';
            addParen(str, leftRem, rightRem-1, index+1, perms);
        }
    }

}
