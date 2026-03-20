/*
 * @lc app=leetcode.cn id=1288 lang=java
 *
 * [1288] 删除被覆盖区间
 */

// @lc code=start
class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        // 1. 排序：左升序，右降序
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1]; // 右端点降序
            }
            return a[0] - b[0]; // 左端点升序
        });

        int count = 0;
        int maxRight = 0;

        // 2. 遍历
        for (int[] interval : intervals) {
            if (interval[1] > maxRight) {
                // 没被覆盖
                count++;
                maxRight = interval[1];
            }
            // 否则就是被覆盖，直接跳过
        }

        return count;
    }
}
// @lc code=end

