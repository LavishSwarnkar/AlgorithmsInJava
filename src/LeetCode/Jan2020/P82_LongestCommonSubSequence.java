package LeetCode.Jan2020;

public class P82_LongestCommonSubSequence {

    public static void main(String args[]){
        System.out.println(longestCommonSubsequence6("pabcdeay", "paaay"));
    }

    //6. Using charArray
    public static int longestCommonSubsequence6(String s, String t) {
        return LCS6(s.toCharArray(), t.toCharArray());
    }

    public static int LCS6(char[] s, char[] t) {
        int[][] len = new int[2][t.length+1];

        for (int i=1 ; i<s.length+1 ; i++) {
            for (int j=1 ; j<t.length+1 ; j++) {
                if (s[i-1] == t[j-1])
                    len[1][j] = len[0][j-1] + 1;
                else
                    len[1][j] = Math.max(len[0][j], len[1][j-1]);
            }

            System.arraycopy(len[1], 0, len[0], 0, t.length + 1);
        }

        return len[1][t.length];
    }

    //5. Reduced Space Memoized DP Bottom-up iterative solution
    public static int longestCommonSubsequence5(String s, String t) {
        int[][] len = new int[2][t.length()+1];

        for (int i=1 ; i<s.length()+1 ; i++) {
            for (int j=1 ; j<t.length()+1 ; j++) {
                if (s.charAt(i-1) == t.charAt(j-1))
                    len[1][j] = len[0][j-1] + 1;
                else
                    len[1][j] = Math.max(len[0][j], len[1][j-1]);
            }

            System.arraycopy(len[1], 0, len[0], 0, t.length() + 1);
        }

        return len[1][t.length()];
    }

    //4. Memoized DP Bottom-up iterative solution
    public static int longestCommonSubsequence4(String s, String t) {
        int[][] len = new int[s.length()+1][t.length()+1];

        for (int i=1 ; i<len.length ; i++) {
            for (int j=1 ; j<len[0].length ; j++) {
                if (s.charAt(i-1) == t.charAt(j-1))
                    len[i][j] = len[i-1][j-1] + 1;
                else
                    len[i][j] = Math.max(len[i-1][j], len[i][j-1]);
            }
        }

        return len[s.length()][t.length()];
    }

    //3. Memoized DP Top-Down recursive solution
    public static int longestCommonSubsequence3(String s, String t) {
        int[][] len = new int[s.length()+1][t.length()+1];
        for(int i=1 ; i<len.length ; i++)
            for(int j=1 ; j<len[0].length ; j++)
                len[i][j] = -1;
        return LCS3(s.length(), t.length(), s, t, len);
    }

    public static int LCS3(int x, int y, String s, String t, int[][] len) {
        if(x==0 || y==0)
            return 0;
        if(x == 1) {
            for (int i=0 ; i<y ; i++)
                if (t.charAt(i) == s.charAt(0))
                    return 1;
            return 0;
        }
        if(y == 1) {
            for (int i=0 ; i<x ; i++)
                if (s.charAt(i) == t.charAt(0))
                    return 1;
            return 0;
        }
        if(len[x][y] == -1){
            if(s.charAt(x-1) == t.charAt(y-1)){
                len[x][y] = 1 + LCS2(x-1, y-1, s, t);
            }
            else {
                if(len[x-1][y] == -1)
                    len[x-1][y] = LCS2(x-1, y, s, t);
                if(len[x][y-1] == -1)
                    len[x][y-1] = LCS2(x, y-1, s, t);
                len[x][y] = Math.max(len[x-1][y], len[x][y-1]);
            }
        }
        return len[x][y];
    }

    //2. Another Recursive solution without substrings
    public static int longestCommonSubsequence2(String s, String t) {
        return LCS2(s.length(), t.length(), s, t);
    }

    public static int LCS2(int x, int y, String s, String t) {
        if(x==0 || y==0)
            return 0;
        if(x == 1) {
            for (int i=0 ; i<y ; i++)
                if (t.charAt(i) == s.charAt(0))
                    return 1;
            return 0;
        }
        if(y == 1) {
            for (int i=0 ; i<x ; i++)
                if (s.charAt(i) == t.charAt(0))
                    return 1;
            return 0;
        }
        if(s.charAt(x-1) == t.charAt(y-1))
            return 1 + LCS2(x-1, y-1, s, t);
        else
            return Math.max(LCS2(x-1, y, s, t)
                    , LCS2(x, y-1, s, t));
    }

    //1. Normal Recursive Solution
    public static int longestCommonSubsequence1(String s, String t) {
        if(s.equals("") || t.equals(""))
            return 0;
        if(s.length() == 1) {
            for (char c : t.toCharArray())
                if (c == s.charAt(0))
                    return 1;
            return 0;
        }
        if(t.length() == 1) {
            for (char c : s.toCharArray())
                if (c == t.charAt(0))
                    return 1;
            return 0;
        }
        if(s.charAt(s.length()-1) == t.charAt(t.length()-1))
            return 1 + longestCommonSubsequence1(s.substring(0, s.length()-1)
                    , t.substring(0, t.length()-1));
        else
            return Math.max(longestCommonSubsequence1(s, t.substring(0, t.length()-1))
                    , longestCommonSubsequence1(s.substring(0, s.length()-1), t));
    }

}
