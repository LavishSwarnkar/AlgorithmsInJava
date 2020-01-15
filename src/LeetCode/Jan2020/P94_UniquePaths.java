package LeetCode.Jan2020;

public class P94_UniquePaths {

    public static void main(String args[]){
        /*System.out.println(uniquePaths1(3, 3));
        System.out.println(uniquePaths1(3, 3));
        System.out.println(uniquePaths1(3, 2));
        System.out.println(uniquePaths1(7, 3));*/

        System.out.println(uniquePaths3(3, 3));
        System.out.println(uniquePaths3(3, 3));
        System.out.println(uniquePaths3(3, 2));
        System.out.println(uniquePaths3(7, 3));
    }

    public static int uniquePaths3(int m, int n) {
        int[][] paths = new int[2][n];
        for(int i=0 ; i<2 ; i++)
            paths[i][0] = 1;
        for(int i=0 ; i<n ; i++)
            paths[0][i] = 1;
        for(int i=1 ; i<m ; i++){
            for(int j=1 ; j<n ; j++) {
                paths[1][j] = paths[0][j] + paths[1][j-1];
            }
            paths[0] = paths[1];
        }
        return paths[0][n-1];
    }

    public static int uniquePaths(int m, int n) {
        int[][] paths = new int[m][n];
        for(int i=0 ; i<m ; i++)
            paths[i][0] = 1;
        for(int i=0 ; i<n ; i++)
            paths[0][i] = 1;
        for(int i=1 ; i<m ; i++){
            for(int j=1 ; j<n ; j++) {
                paths[i][j] = paths[i-1][j] + paths[i][j-1];
            }
        }
        return paths[m-1][n-1];
    }

    private enum Cache{
        NA, TRUE, FALSE
    }
    private static int paths = 1, rows, cols;
    private static int[][] memo;
    public static int uniquePaths2(int m, int n) {
        rows = m;
        cols = n;
        paths = 1;
        memo = new int[m+1][n+1];
        memo[m-1][n-1] = Cache.TRUE.ordinal();
        explorePath2(0, 0);
        return paths;
    }

    private static boolean explorePath2(int r, int c){
        if(r >= rows || c >= cols)
            return false;
        if(r == rows-1 && c == cols-1)
            return true;
        if(memo[r][c] != Cache.NA.ordinal()){
            if(memo[r+1][c] == Cache.TRUE.ordinal() && memo[r][c+1] == Cache.TRUE.ordinal())
                paths++;
            return memo[r][c] == Cache.TRUE.ordinal();
        }
        if(memo[r+1][c] == Cache.NA.ordinal())
            explorePath2(r+1, c);
        if(memo[r][c+1] == Cache.NA.ordinal())
            explorePath2(r, c+1);
        if(memo[r+1][c] == Cache.TRUE.ordinal() && memo[r][c+1] == Cache.TRUE.ordinal())
            paths++;
        memo[r][c] = (memo[r+1][c] == Cache.TRUE.ordinal() || memo[r][c+1] == Cache.TRUE.ordinal()) ? Cache.TRUE.ordinal() : Cache.FALSE.ordinal();
        return memo[r][c] == Cache.TRUE.ordinal();
    }

    //1. Normal recursive solution
    public static int uniquePaths1(int m, int n) {
        rows = m;
        cols = n;
        paths = 1;
        explorePath1(0, 0);
        return paths;
    }

    private static boolean explorePath1(int r, int c){
        if(r >= rows || c >= cols)
            return false;
        if(r == rows-1 && c == cols-1)
            return true;
        boolean r1 = explorePath1(r+1, c)
                , r2 = explorePath1(r, c+1);
        if(r1 && r2)
            paths++;
        return r1 || r2;
    }

}
