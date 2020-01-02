package LeetCode.Jan2020;

import java.util.HashMap;
import java.util.Map;

public class P32_FirstUniqueChar {

    public static void main(String args[]){
        System.out.println(firstUniqChar("loveleetcode"));
    }

    public static int firstUniqChar(String s) {
        int[] occ = new int[26];

        char[] chars = s.toCharArray();
        for(char c : chars){
            occ[c - 'a']++;
        }
        for(int i=0 ; i<chars.length ; i++)
            if(occ[chars[i] - 'a'] == 1)
                return i;
        return -1;
    }

    public static int firstUniqChar2(String s) {
        Map<Character, Integer> occMap = new HashMap<>();
        char[] chars = s.toCharArray();
        for(char c : chars){
            if(occMap.containsKey(c))
                occMap.put(c, occMap.get(c) + 1);
            else
                occMap.put(c, 1);
        }
        for(int i=0 ; i<chars.length ; i++)
            if(occMap.get(chars[i]) == 1)
                return i;
        return -1;
    }

}
