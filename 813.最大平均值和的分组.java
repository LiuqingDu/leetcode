/*
 * @lc app=leetcode.cn id=813 lang=java
 *
 * [813] 最大平均值和的分组
 */

// @lc code=start
class Solution {
    public double largestSumOfAverages(int[] nums, int k) {
        // 首先有一个结论: 平均和最大的分组的数量一定是k
        // 因为如果分组数量小于k，那么至少有一个子数组长度大于1, 可以继续分割
        // 那么分割后平均值之和一定会增大. 考虑原先子数组是[a, b]，分割后变成[a]和[b]，
        // 那么平均值之和变成(a+b)/2 > (a+b)/1
        // 又因为分割数了不大于k，所以分组数一定是k
        // 那么我们可以使用动态规划来求解
        // 定义dp[i][j]表示前i个数分成j组的最大平均值和
        // 用前缀和来优化计算平均值

        int n = nums.length;
        double[] prefixSum = new double[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        double[][] dp = new double[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            dp[i][1] = prefixSum[i] / i; // 只有一组时，平均值就是前i个数的平均值
        }

        for (int j = 2; j <= k; j++) { // 分组数从2到k
            for (int i = j; i <= n; i++) { // 至少需要j个数才能分成j组
                for (int p = j - 1; p < i; p++) { // 前p个数分成j-1组，剩下的i-p个数作为第j组
                    double avg = (prefixSum[i] - prefixSum[p]) / (i - p);
                    dp[i][j] = Math.max(dp[i][j], dp[p][j - 1] + avg);
                }
            }
        }
        return dp[n][k]; // 返回前n个数分成k组的最大平均值和
    }
}
// @lc code=end

