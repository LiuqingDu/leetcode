/*
 * @lc app=leetcode.cn id=3065 lang=java
 *
 * [3065] 超过阈值的最少操作数 I
 */

// @lc code=start
class Solution {
    public int minOperations(int[] nums, int k) {
        int count = 0;
        for (int num : nums) {
            if (num < k) {
                count++;
            }
        }

        return count;
    }
}
// @lc code=end

