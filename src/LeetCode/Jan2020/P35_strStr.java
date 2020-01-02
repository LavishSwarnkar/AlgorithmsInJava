package LeetCode.Jan2020;

public class P35_strStr {

    public static void main(String args[]){
        System.out.println(strStr("mississippi", "issip"));
        System.out.println(strStr("aaaaa", "bba"));
        System.out.println(strStr("mississippi", "pi"));
        System.out.println(strStr("babba", "bbb"));
    }

    //Even faster
    public int strStr3(String haystack, String needle) {
        if(needle.equals(""))
            return 0;
        if(needle.equals(haystack))
            return 0;

        for(int i=0 ; i<haystack.length()-needle.length()+1 ; i++)
            if(haystack.substring(i, i+needle.length()).equals(needle))
                return i;
        return -1;
    }

    public static int strStr(String haystack, String needle) {
        if (haystack == null || needle.length() > haystack.length())
            return -1;
        if (needle.length() == 0)
            return 0;

        char[] s1 = haystack.toCharArray(), s2 = needle.toCharArray();
        for (int i=0 ; i<=s1.length-s2.length ; i++) {
            if(s1[i] != s2[0])
                continue;
            int j;
            for (j=0 ; j<s2.length ; j++)
                if (s2[j] != s1[i+j])
                    break;
            if (j == s2.length)
                return i;
        }

        return -1;
    }

    //Dead-end
    public static int strStr2(String haystack, String needle) {
        if(needle.equals(""))
            return 0;
        char[] s1 = haystack.toCharArray(), s2 = needle.toCharArray();
        int i=0, j=0;
        while (i < s1.length){
            while (i < s1.length && s1[i] != s2[j]) i++;
            while (i < s1.length && j < s2.length && s1[i] == s2[j]){
                i++; j++;
            }

            if(j == s2.length) {
                return i - s2.length;
            } else if(i == s1.length){
                return -1;
            } else {
                j = 0;
                if(s1[i-1] == s2[0] && s1[i] != s2[0])
                    i--;
            }
        }
        return -1;
    }

}
