/*
 * @lc app=leetcode.cn id=718 lang=java
 *
 * [718] 最长重复子数组
 */

// @lc code=start
class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        // 动态规划, 基于公共前缀
        // 记 nums1[i:]表示 nums1 的从索引 i 到末尾之间的子数组
        // 记 dp[i][j] 表示 nums1[i:] 和 nums2[j:] 两个子数组的公共前缀长度
        // 可以看出, 如果 nums1[i] == nums2[j]
        // 那么 dp[i][j] = dp[i+1][j+1] +1
        // 也就是如果两个数字相同, 那么它们到末尾的公共前缀长度
        // 就等于它们后面的子数组的公共前缀长+1
        // 或者说, 从后往前算, 在当前的两个子数组基础上,如果它们左边外的数字相同
        // 那么它们的公共前缀和可以+1
        // 最终答案就是 dp 当中最大值

        int m = nums1.length, n = nums2.length;
        // 因为 dp[i][j] 依赖于 dp[i+1][j+1], 也就是需要 0~m 和 0~n
        // 所以这里长度要多一个
        int[][] dp = new int[m + 1][n + 1];
        int ans = 0;
        // 倒着来
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                dp[i][j] = nums1[i] == nums2[j] ? dp[i + 1][j + 1] + 1 : 0;
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }
}
// @lc code=end

