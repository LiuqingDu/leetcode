/*
 * @lc app=leetcode.cn id=3105 lang=java
 *
 * [3105] 最长的严格递增或递减子数组
 */

// @lc code=start
class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        // 当前递增长度
        int inc = 1;

        // 当前递减长度
        int dec = 1;

        // 最终答案
        int ans = 1;

        for (int i = 1; i < nums.length; i++) {

            // 严格递增
            if (nums[i] > nums[i - 1]) {
                inc++;
                dec = 1;
            }

            // 严格递减
            else if (nums[i] < nums[i - 1]) {
                dec++;
                inc = 1;
            }

            // 相等
            else {
                inc = 1;
                dec = 1;
            }

            // 更新最大值
            ans = Math.max(ans, Math.max(inc, dec));
        }

        return ans;
    }
}
// @lc code=end

