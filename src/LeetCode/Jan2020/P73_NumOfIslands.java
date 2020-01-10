package LeetCode.Jan2020;

public class P73_NumOfIslands {

    public static void main(String args[]){
        char[][] grid = new char[][]{
                  {'1', '1', '1', '1', '0'}
                , {'1', '1', '0', '1', '0'}
                , {'1', '1', '0', '0', '1'}
                , {'0', '0', '1', '1', '0'}
        };
        System.out.println(numIslands(grid));
    }

    private static char[][] grid;
    private static boolean[][] visited;
    private static int num = 0;
    public static int numIslands(char[][] grid) {
        visited = new boolean[grid.length][grid[0].length];
        P73_NumOfIslands.grid = grid;
        for(int i=0 ; i<grid.length ; i++){
            for(int j=0 ; j<grid[0].length ; j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    num++;
                    numIslands(i, j);
                }
            }
        }
        return num;
    }

    public static void numIslands(int i, int j) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length
                || grid[i][j] == '0' || visited[i][j])
            return;
        visited[i][j] = true;
        numIslands(i+1, j);
        numIslands(i-1, j);
        numIslands(i, j+1);
        numIslands(i, j-1);
    }

}