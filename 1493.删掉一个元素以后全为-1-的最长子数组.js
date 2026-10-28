/*
 * @lc app=leetcode.cn id=1493 lang=javascript
 *
 * [1493] 删掉一个元素以后全为 1 的最长子数组
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var longestSubarray = function(nums) {

    const n = nums.length;
    const pre = new Array(n);
    const suf = new Array(n);
    pre[0] = nums[0];
    for (let i = 1; i < n; ++i) {
        pre[i] = nums[i] ? pre[i - 1] + 1 : 0;
    }
    suf[n - 1] = nums[n - 1];
    for (let i = n - 2; i >= 0; --i) {
        suf[i] = nums[i] ? suf[i + 1] + 1 : 0;
    }

    let ans = 0;
    for (let i = 0; i < n; ++i) {
        const preSum = i === 0 ? 0 : pre[i - 1];
        const sufSum = i === n - 1 ? 0 : suf[i + 1];
        ans = Math.max(ans, preSum + sufSum);
    }

    return ans;

};
// @lc code=end

