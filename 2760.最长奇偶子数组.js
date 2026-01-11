/*
 * @lc app=leetcode.cn id=2760 lang=javascript
 *
 * [2760] 最长奇偶子数组
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} threshold
 * @return {number}
 */
var longestAlternatingSubarray = function(nums, threshold) {
    var isSatisfied = function(nums, l, r, threshold) {
        if (nums[l] % 2 != 0) {
            return false;
        }
        for (let i = l; i <= r; i++) {
            if (nums[i] > threshold || (i < r && nums[i] % 2 == nums[i + 1] % 2)) {
                return false;
            }
        }
        return true;
    };
    
    let res = 0;
    for (let l = 0; l < nums.length; l++) {
        for (let r = 0; r < nums.length; r++) {
            if (isSatisfied(nums, l, r, threshold)) {
                res = Math.max(res, r - l + 1);
            }
        }
    }
    return res;
};
// @lc code=end

