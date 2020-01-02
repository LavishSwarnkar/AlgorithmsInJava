package LeetCode.Jan2020;

public class P33_ValidPalindrome {

    public static void main(String args[]){
        System.out.println(isPalindrome("race 2 a 1e   car"));
    }

    public static boolean isPalindrome(String s) {
        char[] chars = s.toLowerCase().toCharArray();
        int i=0, j=chars.length-1;
        while (i<j){
            while (i<j && !(Character.isAlphabetic(chars[i])
                    || Character.isDigit(chars[i])))
                i++;
            while (i<j && !(Character.isAlphabetic(chars[j])
                    || Character.isDigit(chars[j])))
                j--;
            if(chars[i] != chars[j])
                return false;
            i++; j--;
        }
        return true;
    }

    //1ms Solution of another user.
    private static class Solution {
        static int[] map = new int[256];
        static {
            for(int i=0; i<10; i++){
                map[i+'0'] = i+1;
            }
            for(int i=0; i<26; i++){
                map[i+'a'] = map[i+'A'] = i+11;
            }
        }

        public boolean isPalindrome(String s) {
            char[] array = s.toCharArray();
            int lo = 0;
            int hi = array.length-1;
            while(lo < hi){
                while(lo < hi && map[array[lo]] == 0) lo++;
                while(lo < hi && map[array[hi]] == 0) hi--;
                if(lo == hi) return true;
                if(map[array[lo]] == 0 || map[array[hi]] == 0 || map[array[lo++]] != map[array[hi--]]) return false;

            }
            return true;
        }
    }

}
