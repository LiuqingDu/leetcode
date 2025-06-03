/*
 * @lc app=leetcode.cn id=1848 lang=java
 *
 * [1848] 到目标元素的最小距离
 */

// @lc code=start
class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        // 题目意思是: 给定坐标 start, 距离 start 最近的等于 target 的值所在位置
        // 且题目保证 target 存在
        // 那么可以从 start 向两边同时查找,找到为止

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (start - i >= 0 && nums[start - i] == target) {
                return i;
            }
            if (start + i < n && nums[start + i] == target) {
                return i;
            }
        }
        return -1;
    }
}
// @lc code=end

