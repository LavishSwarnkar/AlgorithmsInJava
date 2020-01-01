package LeetCode.Dec2019;

import java.util.Arrays;
import java.util.Stack;

public class P4_ValidParenthesis {

    public static void main(String args[]){
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("([)]"));

        //System.out.println(Arrays.toString(new int[]{'(', ')', '[', ']', '{', '}'}));
    }

    private static boolean isValid(String s){
        char[] cArr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(char c : cArr){
            if(c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                char c2 = stack.pop();
                if(Math.abs(c2 - c) > 2)
                    return false;
            }
        }
        return stack.isEmpty();
    }

}
