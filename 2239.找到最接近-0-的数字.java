/*
 * @lc app=leetcode.cn id=2239 lang=java
 *
 * [2239] 找到最接近 0 的数字
 */

// @lc code=start
class Solution {
    public int findClosestNumber(int[] nums) {
        int res = nums[0];
        // 遍历数组，找到绝对值最小的数字
        // 如果有多个数字的绝对值相同，返回其中最大的一个
        for (int num : nums) {
            if (Math.abs(num) < Math.abs(res) || ((Math.abs(num) == Math.abs(res) && num > res))) {
                res = num;
            }
        }
        return res;
    }
}
// @lc code=end

