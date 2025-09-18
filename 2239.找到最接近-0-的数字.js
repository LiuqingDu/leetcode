/*
 * @lc app=leetcode.cn id=2239 lang=javascript
 *
 * [2239] 找到最接近 0 的数字
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var findClosestNumber = function(nums) {
    let res = nums[0];
    for (let num of nums) {
        if (Math.abs(num) < Math.abs(res) || (Math.abs(num) === Math.abs(res) && num > res)) {
            res = num;
        }
    }
    return res;
};
// @lc code=end

