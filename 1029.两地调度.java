/*
 * @lc app=leetcode.cn id=1029 lang=java
 *
 * [1029] 两地调度
 */

// @lc code=start
class Solution {
    public int twoCitySchedCost(int[][] costs) {
        // 先假设所有人都去 A 市，然后选出 n 个“最适合去 B 市的人”改去 B。
        // 怎么判断“适合去 B”？
        // 看 去 B 比去 A 能省多少钱

        int n = costs.length / 2;

        // 按 (bCost - aCost) 从小到大排序
        Arrays.sort(costs, (a, b) -> (a[1] - a[0]) - (b[1] - b[0]));

        int total = 0;

        // 前 n 个去 B，后 n 个去 A
        for (int i = 0; i < costs.length; i++) {
            if (i < n) {
                total += costs[i][1]; // 去 B
            } else {
                total += costs[i][0]; // 去 A
            }
        }

        return total;
    }
}
// @lc code=end

