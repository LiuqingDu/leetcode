/*
 * @lc app=leetcode.cn id=2057 lang=java
 *
 * [2057] 值相等的最小索引
 */

// @lc code=start
class Solution {
    public int smallestEqual(int[] nums) {
        // 遍历数组，检查索引 i 是否等于 nums[i] 的值
        // 如果相等，返回索引 i
        // 如果没有找到，返回 -1
        for (int i = 0; i < nums.length; i++) {
            if (i % 10 == nums[i]) {
                return i;
            }
        }
        return -1;
    }
}
// @lc code=end

