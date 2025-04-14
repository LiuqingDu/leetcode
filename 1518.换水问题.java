/*
 * @lc app=leetcode.cn id=1518 lang=java
 *
 * [1518] 换水问题
 */

// @lc code=start
class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int res = numBottles;
        while (numBottles >= numExchange) {
            int exc = numBottles / numExchange;
            res += exc;
            int left = numBottles % numExchange;
            numBottles = exc + left;
        }
        return res;
    }
}
// @lc code=end

