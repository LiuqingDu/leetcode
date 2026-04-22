/*
 * @lc app=leetcode.cn id=3046 lang=javascript
 *
 * [3046] 分割数组
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {boolean}
 */
var isPossibleToSplit = function(nums) {
    let arr = new Array(101).fill(0);
    for (let num of nums) {
        arr[num]++;
        if (arr[num] > 2) {
            return false;
        }
    }
    return true;
};
// @lc code=end

