package LeetCode.Jan2020;

import java.util.Stack;

public class P58_ValidParentheses {

    public static void main(String args[]){
        System.out.println(isValid("{()}"));
        System.out.println(isValid("{(})"));
    }

    public static boolean isValid(String s){
        char[] cArr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(char c : cArr){
            if(c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                try{
                    char c2 = stack.pop();
                    if(Math.abs(c2 - c) > 2)
                        return false;
                }catch(Exception e){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
