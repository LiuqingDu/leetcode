/*
 * @lc app=leetcode.cn id=813 lang=javascript
 *
 * [813] 最大平均值和的分组
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var largestSumOfAverages = function(nums, k) {
    let n = nums.length;
    let prefixSum = new Array(n + 1).fill(0);
    for (let i = 0; i < n; i++) {
        prefixSum[i + 1] = prefixSum[i] + nums[i];
    }

    let dp = new Array(n + 1).fill(0).map(() => new Array(k + 1).fill(0));
    for (let i = 1; i <= n; i++) {
        dp[i][1] = prefixSum[i] / i;
    }

    for (let j = 2; j <= k; j++) {
        for (let i = j; i <= n; i++) {
            for (let m = j - 1; m < i; m++) {
                let avg = (prefixSum[i] - prefixSum[m]) / (i - m);
                dp[i][j] = Math.max(dp[i][j], dp[m][j - 1] + avg);
            }
        }
    }

    return dp[n][k];
};
// @lc code=end

