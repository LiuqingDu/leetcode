/*
 * @lc app=leetcode.cn id=674 lang=java
 *
 * [674] 最长连续递增序列
 */

// @lc code=start
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        // 滑动窗口，每次窗口右侧遇到变小的数值，就计算窗口长度并更新res
        // 然后把窗口左侧指向当前窗口右侧
        int res = 0;
        int l = 0;
        while (l < nums.length) {
            int r = l + 1;
            while (r < nums.length && nums[r] > nums[r - 1]) {
                r++;
            }
            res = Math.max(res, r - l);
            l = r;
        }
        return res;
    }
}
// @lc code=end

