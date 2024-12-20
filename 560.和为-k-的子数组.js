/*
 * @lc app=leetcode.cn id=560 lang=javascript
 *
 * [560] 和为 K 的子数组
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var subarraySum = function(nums, k) {
    const n = nums.length;
    const prefixSum = new Array(n + 1).fill(0);
    for (let i = 0; i < n; i++) {
        prefixSum[i + 1] = prefixSum[i] + nums[i];
    }

    let result = 0;
    const countMap = new Map();
    for (const sum of prefixSum) {
        if (countMap.has(sum - k)) {
            result += countMap.get(sum - k);
        }
        countMap.set(sum, (countMap.get(sum) || 0) + 1);
    }
    return result;
};
// @lc code=end

