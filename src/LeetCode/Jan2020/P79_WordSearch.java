package LeetCode.Jan2020;

public class P79_WordSearch {

    public static void main(String args[]){
        char[][] board = {
                {'a'}
        };
        System.out.println(exist(board, "a"));
    }

    private static char[][] board;
    private static char[] word;
    public static boolean exist(char[][] board, String word) {
        P79_WordSearch.board = board;
        P79_WordSearch.word = word.toCharArray();
        for(int r=0 ; r<board.length ; r++)
            for(int c=0 ; c<board[0].length ; c++)
                if(board[r][c] == P79_WordSearch.word[0])
                    if (isPath(r, c, 0))
                        return true;
        return false;
    }

    private static boolean isPath(int r, int c, int index){
        if(r<0 || c<0 || r>=board.length || c>=board[0].length
                || (index < word.length && board[r][c] != word[index]))
            return false;

        if(index == word.length-1)
            return true;

        char tmp = board[r][c];
        board[r][c] = ' ';

        boolean res = isPath(r-1, c, index+1)
                || isPath(r+1, c, index+1)
                || isPath(r, c-1, index+1)
                || isPath(r, c+1, index+1);

        board[r][c] = tmp;

        return res;
    }

}
