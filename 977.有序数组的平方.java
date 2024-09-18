/*
 * @lc app=leetcode.cn id=977 lang=java
 *
 * [977] 有序数组的平方
 */

// @lc code=start
class Solution {
    public int[] sortedSquares(int[] nums) {
        // 从数组两端往中间遍历，依次比较两端哪个平方和大，
        // 放在 res 的末尾
        int l = 0, r = nums.length - 1;
        int[] res = new int[nums.length];
        int ind = nums.length - 1;

        while (l <= r) {
            int m = nums[l] * nums[l];
            int n = nums[r] * nums[r];
            if (m >= n) {
                res[ind] = m;
                l++;
            } else {
                res[ind] = n;
                r--;
            }
            ind--;
        }

        return res;
    }
}
// @lc code=end

