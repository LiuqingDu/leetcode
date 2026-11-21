/*
 * @lc app=leetcode.cn id=3560 lang=java
 *
 * [3560] 木材运输的最小成本
 */

// @lc code=start
class Solution {
    public long minCuttingCost(int n, int m, int k) {
        
        return Math.max((long) k * (Math.max(n, m) - k), 0);
    }
}
// @lc code=end

