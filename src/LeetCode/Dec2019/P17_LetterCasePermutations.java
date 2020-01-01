package LeetCode.Dec2019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class P17_LetterCasePermutations {

    public static void main(String args[]){
        System.out.println(letterCasePermutation2("a1bc"));
        System.out.println(letterCasePermutation2("a1b2"));
    }

    public static ArrayList<String> letterCasePermutation2(String s) {
        ArrayList<String> list = new ArrayList<>();
        recurse(list, s.toCharArray(), 0);
        return list;
    }

    private static void recurse(ArrayList<String> list, char[] s, int index){
        for(int i=0 ; i<index ; i++)
            System.out.print("\t");
        System.out.println("(\"" + String.valueOf(s) + "\", " + index + ")");
        if(index == s.length) {
            list.add(String.valueOf(s));
            return;
        }
        if(!Character.isDigit(s[index])){
            s[index] = Character.toUpperCase(s[index]);
            recurse(list, s, index+1);
            s[index] = Character.toLowerCase(s[index]);
        }
        recurse(list, s, index+1);
    }

    public static ArrayList<String> letterCasePermutation(String s) {
        if(s.length() == 0)
            return new ArrayList<>();
        if(s.length() == 1){
            if(Character.isDigit(s.charAt(0)))
                return new ArrayList<>(Collections.singletonList(s));
            return new ArrayList<>(Arrays.asList( s,
                Character.isUpperCase(s.charAt(0)) ? s.toLowerCase() : s.toUpperCase())
            );
        }
        ArrayList<String> list = letterCasePermutation(s.substring(1, s.length()))
                , newList = new ArrayList<>();

        for(String t : list){
            if(Character.isDigit(s.charAt(0))){
                newList.add(s.charAt(0) + t);
                continue;
            }

            newList.add((Character.isUpperCase(s.charAt(0)) ? (char) (s.charAt(0)+32) : s.charAt(0)) + t);
            newList.add((Character.isLowerCase(s.charAt(0)) ? (char) (s.charAt(0)-32) : s.charAt(0)) + t);
        }
        return newList;
    }

}
