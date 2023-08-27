/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 */

// @lc code=start
/*
 * 动态规划
 * 1. DP数组下标定义，dp[i][0]，第i天持有股票所得最大股票；dp[i][1]，不持股最大现金
 * 
 */
class Solution {
    public int maxProfit(int[] prices) {
        // if (prices == null || prices.length == 0) {
        //     return 0;
        // }
        // int n = prices.length;
        // int[] dp = new int[n];
        // dp[0] = 0;
        // int minPrice = prices[0];
        // for(int i = 1; i < n; i++) {
        //     dp[i] = Math.max(dp[i-1], prices[i] - minPrice);
        //     minPrice = Math.min(minPrice, prices[i]);
        // }
        // return dp[n-1];
        return dp2(prices);
     }

     public static int dp2(int[] prices){
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int len = prices.length;
        // dp[i][0]代表第i天持有股票的最大收益
        // dp[i][1]代表第i天不持有股票的最大收益
        int[][] dp = new int[len][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for(int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i-1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i-1][0] + prices[i],dp[i-1][1]);
        }
        return dp[len-1][1];
     }
}
// @lc code=end

