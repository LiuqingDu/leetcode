/*
 * @lc app=leetcode.cn id=775 lang=javascript
 *
 * [775] 全局倒置与局部倒置
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {boolean}
 */
var isIdealPermutation = function(nums) {
    
    let n = nums.length, minSuff = nums[n - 1];
    for (let i = n - 3; i >= 0; i--) {
        if (nums[i] > minSuff) {
            return false;
        }
        minSuff = Math.min(minSuff, nums[i + 1]);
    }
    return true;

};
// @lc code=end

