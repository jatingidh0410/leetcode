/*
 * 
maxProfit is used to store the maximum profit directly instead of a separate variable sell.
The loop iterates through each element of the prices array.
minPrice is updated to store the minimum buying price encountered so far.
maxProfit is updated to store the maximum profit by calculating the difference between the current stock price and the minimum buying price.
The loop continues to iterate through the entire array, updating minPrice and maxProfit at each step based on the encountered stock prices.
The method returns the final value of maxProfit, representing the maximum profit achievable by buying the stock at the lowest possible price and selling it at the highest possible price
 */
class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0, minPrice = Integer.MAX_VALUE;

        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }

        return maxProfit;
    }
}
