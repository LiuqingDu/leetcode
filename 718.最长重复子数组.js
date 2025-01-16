/*
 * @lc app=leetcode.cn id=718 lang=javascript
 *
 * [718] 最长重复子数组
 */

// @lc code=start
/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */
var findLength = function(nums1, nums2) {
    let m = nums1.length, n = nums2.length;
    let dp = Array.from(new Array(m + 1), () => new Array(n + 1).fill(0));

    let res = 0;
    for (let i = m - 1; i >= 0; i--) {
        for (let j = n - 1; j >= 0; j--) {
            dp[i][j] = nums1[i] === nums2[j] ? dp[i+1][j+1] + 1 : 0;
            res = Math.max(res, dp[i][j]);
        }
    }
    return res;
};
// @lc code=end

