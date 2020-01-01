package LeetCode.Jan2020;

public class P26_BuyAndSellStock2 {

    public static void main(String args[]){
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(maxProfit(new int[]{1,2,3,4,5}));
        System.out.println(maxProfit(new int[]{1, 7, 2, 3, 6, 7, 6, 7}));
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));

    }

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        for(int i=1 ; i<prices.length ; i++){
            if(prices[i] > prices[i-1])
                maxProfit += prices[i] - prices[i-1];
        }
        return maxProfit;
    }

}
