/*
 * @lc app=leetcode.cn id=2656 lang=java
 *
 * [2656] K 个元素的最大和
 */

// @lc code=start
class Solution {
    public int maximizeSum(int[] nums, int k) {
        int m = Arrays.stream(nums).max().getAsInt();
        return (2 * m + k - 1) * k / 2;
    }
}
// @lc code=end

