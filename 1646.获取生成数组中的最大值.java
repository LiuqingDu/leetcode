/*
 * @lc app=leetcode.cn id=1646 lang=java
 *
 * [1646] 获取生成数组中的最大值
 */

// @lc code=start
class Solution {
    public int getMaximumGenerated(int n) {
        if (n == 0) {
            return 0;
        }
        int[] nums = new int[n + 1];
        nums[0] = 0;
        nums[1] = 1;
        for (int i = 0; i < n; i++) {
            if (2 * i <= n) {
                nums[2 * i] = nums[i];
            }
            if (2 * i + 1 <= n) {
                nums[2 * i + 1] = nums[i] + nums[i + 1];
            }
        }
        int ans = 0;
        for (int i : nums) {
            ans = Math.max(ans, i);
        }
        return ans;
    }
}
// @lc code=end

