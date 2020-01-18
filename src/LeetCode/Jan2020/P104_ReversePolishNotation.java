package LeetCode.Jan2020;

import java.util.Stack;

public class P104_ReversePolishNotation {

    public static void main(String args[]){
        System.out.println(evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));;
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String token : tokens){
            switch (token){
                case "+" : {
                    stack.push(stack.pop() + stack.pop());
                    break;
                } case "-" : {
                    int b = stack.pop();
                    stack.push(stack.pop() - b);
                    break;
                } case "*" : {
                    stack.push(stack.pop() * stack.pop());
                    break;
                } case "/" : {
                    int b = stack.pop();
                    stack.push(stack.pop() / b);
                    break;
                } default : {
                    stack.push(Integer.parseInt(token));
                }
            }
        }
        return stack.pop();
    }

    //1ms solution
    int index;
    public int evalRPN2(String[] tokens) {
        index = tokens.length-1;
        return eval(tokens);
    }
    private int eval(String[] tokens){
        String token = tokens[index--];
        char c = token.charAt(token.length()-1);
        if ( '0' <= c && c <= '9' ){
            return Integer.parseInt(token);
        } else {
            int v1 = eval(tokens);
            int v2 = eval(tokens);
            if(token.equals("+")) return v2+v1;
            if(token.equals("-")) return v2-v1;
            if(token.equals("*")) return v2*v1;
            if(token.equals("/")) return v2/v1;
            return 0;
        }
    }

}
