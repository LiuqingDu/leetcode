/*
 * @lc app=leetcode.cn id=2733 lang=java
 *
 * [2733] 既不是最小值也不是最大值
 */

// @lc code=start
class Solution {
    public int findNonMinOrMax(int[] nums) {
        // 前三个数字就能出现一个非最大非最小的
        // 对前三个数字排序后取第二个
        if (nums.length < 3) return -1;
        Arrays.sort(nums, 0, 3); // 只对前三个数排序
        return nums[1];
    }
}
// @lc code=end

