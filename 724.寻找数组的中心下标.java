/*
 * @lc app=leetcode.cn id=724 lang=java
 *
 * [724] 寻找数组的中心下标
 */

// @lc code=start
class Solution {

    // 题目要求返回最左边的中心下标，表示应该从左边往右寻找
    // 假设中心下标为0，那么左边的和为0，右边的和为所有元素的和减去当前中心元素
    // 如果左右不相等则把当前中心值加给左边，再把中心往右移动，
    // 右边的值再减去新的中心值进行下一轮比较
    public int pivotIndex(int[] nums) {
        int left = 0;
        int right = 0;
        // 计算所有元素的和
        for (int i = 0; i < nums.length; i++) {
            right+=nums[i];
        }
        // 依次寻找中心点
        for (int i = 0; i < nums.length; i++) {
            // 右边的和先减去当前的中心值
            right -= nums[i];
            if (left == right) {
                return i;
            } else {
                // 如果不等，左边的加上当前中心值，继续下一轮
                left += nums[i];
            }
        }
        return -1;
    }
}
// @lc code=end

