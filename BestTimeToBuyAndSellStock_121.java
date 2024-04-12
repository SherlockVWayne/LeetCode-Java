package LeetCode;

public class BestTimeToBuyAndSellStock_121 {
    
    public int maxProfit_II(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        
        int globalMinPrice = Integer.MAX_VALUE;
        int maxProfix = 0;
        for (int price : prices) {
            if (price < globalMinPrice) {
                globalMinPrice = price;
            } else if (price - globalMinPrice > maxProfix) {
                maxProfix = price - globalMinPrice;
            }
        }
        return maxProfix;
    }
    
    public int maxProfit(int[] prices) {
        int minVal = Integer.MAX_VALUE;
        int maxProfit = 0;
        
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minVal) {
                minVal = prices[i];
            } else if (prices[i] - minVal > maxProfit) {
                maxProfit = prices[i] - minVal;
            }
        }
        
        return maxProfit;
    }
}
