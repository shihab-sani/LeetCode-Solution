class Profit {
    public int maxProfit(int[] prices) {
        int buy = 0;
        int profit = 0;
        int max_profit = 0;

        for (int sell = 0; sell < prices.length; sell++) {
            if (prices[buy] > prices[sell] || (prices[sell] - prices[buy]) < profit) {
                buy = sell;
                max_profit += profit; 
                profit = 0;
            } 
            profit = Math.max(profit,prices[sell] - prices[buy]);  
        }
        max_profit += profit; 
        return max_profit;
    }
}