package LeetCode.Jan2020;

public class P28_ValidSudoku {

    public static void main(String args[]){

    }

    public static boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9]
                , col = new boolean[9][9];
        boolean[] currBlock;

        for(int i=0 ; i<3 ; i++){
            for(int j=0 ; j<3 ; j++){

                currBlock = new boolean[9];

                for(int k=0 ; k<3 ; k++){
                    for(int l=0 ; l<3 ; l++){
                        if(board[i*3 + k][j*3 + l] == '.')
                            continue;

                        int index = board[i*3 + k][j*3 + l] - 48;

                        if(currBlock[index]
                                || row[i*3 + k][index]
                                || col[j*3 + l][index])
                            return false;

                        currBlock[index] = true;
                        row[i*3 + k][index] = true;
                        col[j*3 + l][index] = true;
                    }
                }
            }
        }
        return true;
    }

}
