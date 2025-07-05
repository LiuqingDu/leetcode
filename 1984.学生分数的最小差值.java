/*
 * @lc app=leetcode.cn id=1984 lang=java
 *
 * [1984] 学生分数的最小差值
 */

// @lc code=start
class Solution {
    public int minimumDifference(int[] nums, int k) {
        // 首先肯定要排序
        // 然后使用滑动窗口来找到最小差值
        Arrays.sort(nums);
        int n = nums.length;
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i + k - 1 < n; i++) {
            // 计算当前窗口的差值
            int diff = nums[i + k - 1] - nums[i];
            // 更新最小差值
            minDiff = Math.min(minDiff, diff);
        }
        // 如果没有找到合适的窗口，返回 -1
        return minDiff == Integer.MAX_VALUE ? -1 : minDiff;
    }
}
// @lc code=end

