/*
 * @lc app=leetcode.cn id=977 lang=javascript
 *
 * [977] 有序数组的平方
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number[]}
 */
var sortedSquares = function(nums) {
    let l = 0, r = nums.length - 1;
    let res = [];

    while (l <= r) {
        let m = nums[l] * nums[l];
        let n = nums[r] * nums[r];
        if (m >= n) {
            res.unshift(m);
            l++;
        } else {
            res.unshift(n);
            r--;
        }
    }

    return res;
};
// @lc code=end

