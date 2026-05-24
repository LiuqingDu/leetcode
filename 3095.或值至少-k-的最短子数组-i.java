/*
 * @lc app=leetcode.cn id=3095 lang=java
 *
 * [3095] 或值至少 K 的最短子数组 I
 */

// @lc code=start
class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int or = 0;

            for (int j = i; j < n; j++) {
                or |= nums[j];

                if (or >= k) {
                    ans = Math.min(ans, j - i + 1);
                    break; // 不需要再扩展了
                }
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
// @lc code=end

