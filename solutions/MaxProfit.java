class MaxProfit {
    public int maxProfit(int[] prices) {
        int buy = 0;
        int profit = 0;

        for (int sell = 0; sell < prices.length; sell++) {
            if (prices[buy] > prices[sell]) 
                buy = sell;
            profit = Math.max(profit,prices[sell] - prices[buy]);
        }
        return profit;
    }
}