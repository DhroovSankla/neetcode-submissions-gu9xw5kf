class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        for(int i = 0; i < prices.length; i++) {
            for(int j = i+1; j < prices.length; j++) {
                int currProfit = prices[j] - prices[i];

                if(currProfit > maxProfit) {
                    maxProfit = currProfit;
                }
            }
        }
        return maxProfit;
    }
}
