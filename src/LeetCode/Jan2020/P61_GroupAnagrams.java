package LeetCode.Jan2020;

import java.util.*;

public class P61_GroupAnagrams {

    public static void main(String args[]){

    }

    //Sorting and Hashing
    public ArrayList<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            String sortedString = getSortedString(s);
            if(!map.containsKey(sortedString))
                map.put(sortedString, new ArrayList<>());
            map.get(sortedString).add(s);
        }
        return new ArrayList<>(map.values());
    }

    private static String getSortedString(String s){
        char[] c = s.toCharArray();
        Arrays.sort(c);
        return String.valueOf(c);
    }

    //Count Characters
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) count[c - 'a']++;

            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        List<List<String>> lists = new ArrayList(ans.values());
        return lists;
    }

}
