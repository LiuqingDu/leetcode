/*
 * @lc app=leetcode.cn id=3010 lang=java
 *
 * [3010] 将数组分成最小总代价的子数组 I
 */

// @lc code=start
class Solution {
    public int minimumCost(int[] nums) {
        Arrays.sort(nums, 1, nums.length);
        return nums[0] + nums[1] + nums[2];
    }
}
// @lc code=end

