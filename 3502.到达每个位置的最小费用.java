/*
 * @lc app=leetcode.cn id=3502 lang=java
 *
 * [3502] 到达每个位置的最小费用
 */

// @lc code=start
class Solution {
    public int[] minCosts(int[] cost) {
        
        // 其实就是，你可以跟目标直接换位置，或者，跟目标左侧的人换位置，然后免费换到目标位置上
        // 所以就是在 【0，目标位置】之间，找一个最小值，换到这个最小值上，然后可以免费换到目标位置上
        // 可以从左侧开始，依次把最小值更新到对应位置上
        // 每次循环，左侧的位置就是左边所有值当中的最小值
        for (int i = 1; i < cost.length; i++) {
            cost[i] = Math.min(cost[i], cost[i - 1]);
        }
        return cost;

    }
}
// @lc code=end

