package LeetCode.Jan2020;

public class P62_LongestSubstrWithoutRepeatingCharacter {

    public static void main(String args[]){
        System.out.println(lengthOfLongestSubstring("abbcde"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        char[] chars = s.toCharArray();
        int repeatIndex = 0, start = 0, end = 0;
        for(int i=0;i<chars.length;i++){
            for(int j=repeatIndex;j<i;j++){
                if(chars[i]==chars[j]){
                    if(i-repeatIndex > maxLength){
                        maxLength=i-repeatIndex;
                        start = j+1;
                        end = i;
                    }
                    repeatIndex=j+1;
                    break;
                }
            }
        }
        if(chars.length - repeatIndex > maxLength){
            maxLength = chars.length - repeatIndex;
            start = repeatIndex;
            end = chars.length-1;
        }
        System.out.println(s.substring(start, end+1));
        return maxLength;
    }

}
