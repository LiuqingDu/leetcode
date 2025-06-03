/*
 * @lc app=leetcode.cn id=1848 lang=javascript
 *
 * [1848] 到目标元素的最小距离
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} target
 * @param {number} start
 * @return {number}
 */
var getMinDistance = function(nums, target, start) {
    let n = nums.length;
    for (let i = 0; i < n; i++) {
        if (start - i >= 0 && nums[start - i] === target) {
            return i;
        }
        if (start + i < n && nums[start + i] === target) {
            return i;
        }
    }
    return -1;
};
// @lc code=end

