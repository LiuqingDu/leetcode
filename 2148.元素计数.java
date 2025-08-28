/*
 * @lc app=leetcode.cn id=2148 lang=java
 *
 * [2148] 元素计数
 */

// @lc code=start
class Solution {
    public int countElements(int[] nums) {
        // 1. 先找出最大值和最小值
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
        }
        // 2. 统计在区间 [min, max] 内的元素个数
        int count = 0;
        for (int num : nums) {
            if (num > min && num < max) {
                count++;
            }
        }
        return count;
    }
}
// @lc code=end

