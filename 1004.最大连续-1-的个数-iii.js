/*
 * @lc app=leetcode.cn id=1004 lang=javascript
 *
 * [1004] 最大连续1的个数 III
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var longestOnes = function(nums, k) {
    let n = nums.length;
    let left = 0, lsum = 0, rsum = 0;
    let res = 0;

    for (let right = 0; right < n; right++) {
        rsum += 1 - nums[right];
        while (lsum < rsum - k) {
            lsum += 1 - nums[left];
            left++;
        }
        res = Math.max(res, right - left + 1);
    }
    return res;
};
// @lc code=end

