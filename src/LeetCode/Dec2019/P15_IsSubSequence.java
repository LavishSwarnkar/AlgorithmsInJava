package LeetCode.Dec2019;

public class P15_IsSubSequence {

    public static void main(String args[]){
        System.out.println(isSubsequence("abc", "ahbgdc"));
        System.out.println(isSubsequence("axc", "ahbgdc"));
    }

    public static boolean isSubsequence(String s, String t) {
        if(s.length() == 0)
            return true;
        if(t.length() == 0)
            return false;

        char[] sChars = s.toCharArray();
        int i=0;

        for(char c : sChars){
            i = t.indexOf(c, i);
            if(i == -1)
                return false;
            i++;
        }

        return true;
    }

}
