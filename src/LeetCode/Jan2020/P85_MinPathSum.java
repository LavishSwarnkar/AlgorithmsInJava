package LeetCode.Jan2020;

public class P85_MinPathSum {

    public static void main(String args[]){
        System.out.println(minPathSum2(new int[][]{
                {2, 1, 1}
                , {1, 5, 1}
                , {4, 2, 2}
        }));
        System.out.println(minPathSum2(new int[][]{
                {2, 3}
                , {1, 2}
        }));
    }

    public static int minPathSum2(int[][] grid) {
        if(grid.length == 0)
            return 0;
        for(int i=0 ; i<grid.length ; i++){
            for(int j=0 ; j<grid.length ; j++) {
                if(i == 0 && j == 0)
                    continue;
                if(i == 0)
                    grid[0][j] += grid[0][j-1];
                else if(j == 0)
                    grid[i][0] += grid[i-1][0];
                else
                    grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }

    //1. Using recursion
    private static int[][] grid;
    public static int minPathSum1(int[][] grid) {
        P85_MinPathSum.grid = grid;
        return getMinPathSum(grid.length-1, grid[0].length-1);
    }

    private static int getMinPathSum(int r, int c){
        if(r < 0 || c < 0)
            return Integer.MAX_VALUE;
        if(r == 0 && c == 0)
            return grid[r][c];
        return grid[r][c] + Math.min(getMinPathSum(r-1, c), getMinPathSum(r, c-1));
    }

}
