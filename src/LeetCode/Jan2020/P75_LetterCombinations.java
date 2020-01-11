package LeetCode.Jan2020;

import java.util.ArrayList;
import java.util.List;

public class P75_LetterCombinations {

    public static void main(String args[]){
        System.out.println(letterCombinations("52"));
    }

    public static List<String> letterCombinations(String digits) {
        List<String> combs = new ArrayList<>();
        letterCombs("", digits, combs);
        return combs;
    }

    private static void letterCombs(String prefix, String digits, List<String> combs){
        if(digits.length() == 0){
            combs.add(prefix);
            return;
        }
        char thisDigit = digits.charAt(0)
                , end = (char) endAlphabet(thisDigit);
        for(char i = (char) startAlphabet(thisDigit) ; i< end; i++)
            letterCombs(prefix + i
                    , digits.length() > 1 ? digits.substring(1) : ""
                    , combs);
    }

    private static int startAlphabet(char c){
        if(c < '7')
            return ((c - '0')-2)*3 + 97;
        else if(c == '7')
            return 'p';
        else if(c == '8')
            return 't';
        else
            return 'w';
    }

    private static int endAlphabet(char c){
        if(c < '7')
            return ((c - '0')-1)*3 + 97;
        else if(c == '7')
            return 't';
        else if(c == '8')
            return 'w';
        else
            return 'z'+1;
    }

}
