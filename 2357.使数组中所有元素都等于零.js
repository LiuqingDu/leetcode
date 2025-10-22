/*
 * @lc app=leetcode.cn id=2357 lang=javascript
 *
 * [2357] 使数组中所有元素都等于零
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var minimumOperations = function(nums) {
    const set = new Set();
    for (const num of nums) {
        if (num > 0) {
            set.add(num);
        }
    }
    return set.size;
};
// @lc code=end

