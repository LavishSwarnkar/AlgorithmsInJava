package LeetCode.Jan2020;

public class P37_LongestCommonPrefix {

    public static void main(String args[]){
        System.out.println(longestCommonPrefix2(new String[]{"dog","racecar","car"}));
        System.out.println(longestCommonPrefix2(new String[]{"c","ac"}));
        System.out.println(longestCommonPrefix2(new String[]{"flower","flight"}));
    }

    public static String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }

    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";
        if(strs.length == 1)
            return strs[0];
        int i=0;
        while (i<strs[0].length()){
            char c = strs[0].charAt(i);
            int j=0;
            for( ; j<strs.length ; j++)
                if(c != strs[j].charAt(i))
                    break;
            if(j != strs.length)
                return strs[0].substring(0, i);
            else if(i == strs[0].length()-1)
                return strs[0];
            i++;
        }
        return "";
    }

}
