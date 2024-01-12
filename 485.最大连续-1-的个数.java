/*
 * @lc app=leetcode.cn id=485 lang=java
 *
 * [485] 最大连续 1 的个数
 */

// @lc code=start
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {

        int n = nums.length;
        int pos = 0;
        int res = 0, count = 0;

        while (pos < n) {
            if (nums[pos] == 1) {
                count++;
            } else {
                res = Math.max(res, count);
                count = 0;
            }
            pos++;
        }

        res = Math.max(res, count);

        return res;

    }
}
// @lc code=end

