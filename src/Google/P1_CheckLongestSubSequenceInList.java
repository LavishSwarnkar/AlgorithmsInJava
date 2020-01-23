package Google;

public class P1_CheckLongestSubSequenceInList {

    public static void main(String args[]){
        System.out.println(isSubSequence("abppplee", "able"));
        System.out.println(isSubSequence("abppplee", "ale"));
        System.out.println(isSubSequence("abppplee", "apple"));
        System.out.println(isSubSequence("abppplee", "bale"));
        System.out.println(isSubSequence("abppplee", "kangaroo"));
    }

    private static boolean isSubSequence(String s, String t){
        if(t.length() == 0)
            return true;
        if(s.length() == 0 || s.length() < t.length())
            return false;
        char[] sChars = s.toCharArray(), tChars = t.toCharArray();
        for(int i=0 ; i < s.length()-t.length() ; i++){
            if(sChars[i] != tChars[0])
                continue;
            int j=0, k=i;
            while (j<tChars.length && k<sChars.length){
                if(tChars[j] == sChars[k])
                    j++;
                k++;
            }
            if(j == tChars.length)
                return true;
        }
        return false;
    }

}
