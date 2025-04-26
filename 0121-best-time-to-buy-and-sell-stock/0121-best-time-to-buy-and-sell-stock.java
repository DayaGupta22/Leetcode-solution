class Solution {
    public int maxProfit(int[] prices) {
        int maxprofit=0;
        int bestbuy = prices[0];
        for (int i=0;i<prices.length;i++){
            if (prices[i] > bestbuy){ // find maximum profit for next sell time 
                maxprofit = Math.max(maxprofit,prices[i]-bestbuy);
            }
            bestbuy = Math.min(bestbuy , prices[i]); // find minmum prices for bought the sell the lucky charm
        }
        return maxprofit;
    }
}