package LeetCode.Jan2020;

public class P62_LongestSubstrWithoutRepeatingCharacter {

    public static void main(String args[]){
        System.out.println(lengthOfLongestSubstring("abcdabcefdvbnm"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        char[] chars = s.toCharArray();
        int repeatIndex = 0;
        for(int i=0;i<chars.length;i++){
            for(int j=repeatIndex;j<i;j++){
                if(chars[i]==chars[j]){
                    maxLength=Math.max(maxLength,i-repeatIndex);
                    repeatIndex=j+1;
                    break;
                }
            }
        }
        return Math.max(chars.length - repeatIndex, maxLength);
    }

}
