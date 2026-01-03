/*
 * @lc app=leetcode.cn id=2717 lang=javascript
 *
 * [2717] 半有序排列
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var semiOrderedPermutation = function(nums) {
    let n = nums.length;
    let first = 0;
    let last = 0;
    for (let i = 0; i < n; i++) {
        if (nums[i] === 1) {
            first = i;
        } else if (nums[i] === n) {
            last = i;
        }
    }
    if (last > first) {
        return first + (n - 1 - last);
    } else {
        return first + (n - 1 - last) - 1;
    }
};
// @lc code=end

