/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        int maxlen = 0;
        int l = 0;
        int r = 0;
        boolean[][] dp = new boolean[len][len];
        for(int i = len - 1; i >= 0; i--) {
            for(int j = i; j < len; j++) {
                if(chars[i] == chars[j]) {
                    if(j - i <= 1){
                        dp[i][j] = true;
                    }else if (dp[i+1][j-1]) {
                        dp[i][j] = true;
                    }
                }
                if(dp[i][j] && j-i+1 > maxlen) {
                    maxlen = j-i+1;
                    l = i;
                    r = j;
                }
            }
        }
        return s.substring(l, l + maxlen);
    }
}
// @lc code=end

