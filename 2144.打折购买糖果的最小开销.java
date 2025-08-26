/*
 * @lc app=leetcode.cn id=2144 lang=java
 *
 * [2144] 打折购买糖果的最小开销
 */

// @lc code=start
class Solution {
    public int minimumCost(int[] cost) {
        // 每两个送一个,为了使送的价值最高,那么买的两个也得是价格最高的
        // 然后送价格第三高的,以此类推
        Arrays.sort(cost);
        int n = cost.length;
        int totalCost = 0;
        for (int i = 0; i < n; i++) {
            if ((i + 1) % 3 != 0) {
                totalCost += cost[n - 1 - i];
            }
        }
        return totalCost;
    }
}
// @lc code=end

