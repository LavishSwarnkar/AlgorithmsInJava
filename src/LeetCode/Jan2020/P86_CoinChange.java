package LeetCode.Jan2020;

import java.util.Arrays;

public class P86_CoinChange {

    public static void main(String args[]){
        System.out.println(coinChange3(new int[]{2}, 3));
        System.out.println(coinChange3(new int[]{1, 2, 5}, 11));
        System.out.println(coinChange3(new int[]{2, 5}, 23));
    }

    private static int coinChange3(int[] coins, int amount) {
        int[] sols = new int[amount+1];
        for(int i=1 ; i<=amount ; i++){
            int minSol = 0;
            for(int coin : coins){
                if(i == coin){
                    minSol = 1;
                    break;
                } else if(i > coin){
                    int sol = sols[i - coin] + 1;
                    if(sol == 1)
                        continue;
                    minSol = minSol == 0 || sol < minSol ? sol : minSol;
                }
            }
            sols[i] = minSol;
        }
        return sols[amount] == 0 ? -1 : sols[amount];
    }

    private static int coinChange2(int[] coins, int amount) {
        Arrays.sort(coins);
        int pieces = 0, remainder;

        for(int i = coins.length-1 ; i>=0 && amount!=0 ; i--) {
            if (amount % coins[i] == 0) {
                pieces += amount/coins[i];
                amount = 0;
            } else {
                pieces += amount/coins[i];
                remainder = amount%coins[i];
                amount = remainder;
            }
        }
        return amount == 0 ? pieces : -1;
    }

    public static int coinChange1(int[] coins, int amount) {
        int min = 0;
        for(int coin : coins){
            if(amount == coin){
                return 1;
            } else if(amount > coin){
                min = min == 0 ? coinChange1(coins, amount - coin)
                        : Math.min(min, coinChange1(coins, amount - coin));
            }
        }

        return min == 0 || min == -1 ? -1 : min + 1;
    }

}
