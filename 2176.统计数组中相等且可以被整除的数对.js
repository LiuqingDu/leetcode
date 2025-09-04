/*
 * @lc app=leetcode.cn id=2176 lang=javascript
 *
 * [2176] 统计数组中相等且可以被整除的数对
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var countPairs = function(nums, k) {
    let count = 0;
    for (let i = 0; i < nums.length; i++) {
        for (let j = i + 1; j < nums.length; j++) {
            if (nums[i] === nums[j] && (i * j) % k === 0) {
                count++;
            }
        }
    }
    return count;
};
// @lc code=end

