package other;


// Determain the best time to buy and sell stocks to maximize profit
// Multiple trades allowed

public class BestTimeToBuyAndSellII {
    public int maxProfit(int[] prices) {

        //Intilize Variables
        int profit = 0;
        int holdingValue = 0; //you can buy a stock for zero apparently
        boolean holding = false;

        //Basic idea is to look at day ahead to find local maxima and minima
        for (int today = 0; today < prices.length-1; today++){
            if (prices[today+1] > prices[today] && !holding){
                    holdingValue = prices[today]; //buy stock before prices increases if you need to buy
                    holding = true;

            }
            else if (prices[today+1] < prices[today] && holding){ //sell stock before price decreases if you need to sell
                    profit += prices[today]-holdingValue;
                    holding = false;
            }
        }

        //Sell out on last day if we have anything (avoids null issue)
        if (holding){
            profit += prices[prices.length-1]-holdingValue;
        }
        return profit;
    }
}
