package LeetCode.Dec2019;

import java.util.ArrayList;
import java.util.Arrays;

public class P20_N_Queens {

    public static void main(String args[]){
        ArrayList<ArrayList<String>> ans = solveNQueens(8);
        String s = ans.toString().replace("], [", "],\n\n [").replace(", ", "\n  ");
        System.out.println(s);
    }

    private static boolean[] cols, diags1, diags2;
    private static ArrayList<ArrayList<String>> ans = new ArrayList<>();
    private static String[] thisAns;

    public static ArrayList<ArrayList<String>> solveNQueens(int n) {
        cols = new boolean[n];
        diags1 = new boolean[2*n-1];
        diags2 = new boolean[2*n-1];
        thisAns = new String[n];
        ans.clear();
        solve(0, n);
        return ans;
    }

    private static void solve(int row, int n) {
        if(row == n) {
            ans.add(new ArrayList<>(Arrays.asList(thisAns)));
            return;
        }

        for(int col=0 ; col<n ; col++){
            if(!cols[col] && !diags1[row-col+n-1] && !diags2[row+col]){
                cols[col] = diags1[row-col+n-1] = diags2[row+col] = true;
                addToAns(n, row, col);
                solve(row+1, n);
                cols[col] = diags1[row-col+n-1] = diags2[row+col] = false;
            }
        }
    }

    private static void addToAns(int n, int row, int col){
        StringBuilder builder = new StringBuilder();
        for(int i=0 ; i<n ; i++)
            builder.append(i==col ? "Q" : ".");
        thisAns[row] = builder.toString();
    }

}
