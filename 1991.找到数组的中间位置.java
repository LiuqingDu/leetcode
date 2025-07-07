/*
 * @lc app=leetcode.cn id=1991 lang=java
 *
 * [1991] 找到数组的中间位置
 */

// @lc code=start
class Solution {
    public int findMiddleIndex(int[] nums) {
        // 计算数组的总和
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        // 计算左侧和
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            // 如果左侧和等于右侧和，则返回当前索引
            if (leftSum == totalSum - leftSum - nums[i]) {
                return i;
            }
            // 更新左侧和
            leftSum += nums[i];
        }
        // 如果没有找到满足条件的索引，返回 -1
        return -1;
    }
}
// @lc code=end

