class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        int minPrice = prices[0];

        for(int i = 1; i < prices.length ; i++) {
            if(prices[i] < minPrice) {
                minPrice = prices[i];
            }
            res = Math.max(res,prices[i] - minPrice);
        }
        return res;
    }
}
