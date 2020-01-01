package LeetCode.Dec2019;

public class P5_BestBuyAndSellStock {

    public static void main(String args[]){
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(maxProfit(new int[]{7,6,4,3,1}));
        System.out.println(maxProfit(new int[]{2,4,1}));
        System.out.println(maxProfit(new int[]{3,2,6,5,0,3}));
    }

    public static int maxProfit(int[] prices) {
        if(prices.length == 0)
            return 0;

        int min = Integer.MAX_VALUE, max = -1, prevProfit = 0;
        for(int i : prices){
            if(i < min){
                if(max != -1)
                    prevProfit = Math.max(prevProfit, max - min);
                min = i;
                max = -1;
            } else if(i > max) {
                max = i;
            }
        }
        return Math.max(prevProfit, (max - min));
    }

}
