/*
 * @lc app=leetcode.cn id=523 lang=javascript
 *
 * [523] 连续的子数组和
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {boolean}
 */
var checkSubarraySum = function(nums, k) {
    let n = nums.length;
    let sum = [0];
    for (let i = 1; i <= n; i++) {
        sum[i] = sum[i - 1] + nums[i - 1];
    }
    let set = new Set();
    for (let i = 2; i <= n; i++) {
        set.add(sum[i - 2] % k);
        if (set.has(sum[i] % k)) {
            return true;
        }
    }
    return false;
};
// @lc code=end

