/*
 * @lc app=leetcode.cn id=2903 lang=javascript
 *
 * [2903] 找出满足差值条件的下标 I
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} indexDifference
 * @param {number} valueDifference
 * @return {number[]}
 */
var findIndices = function(nums, indexDifference, valueDifference) {
    for (let i = 0; i < nums.length; i++) {
        for (let j = i; j < nums.length; j++) {
            if (j - i >= indexDifference && Math.abs(nums[j] - nums[i]) >= valueDifference) {
                return [i, j];
            }
        }
    }
    return [-1, -1];
};
// @lc code=end

