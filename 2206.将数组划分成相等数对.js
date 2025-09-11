/*
 * @lc app=leetcode.cn id=2206 lang=javascript
 *
 * [2206] 将数组划分成相等数对
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {boolean}
 */
var divideArray = function(nums) {
    const count = new Array(501).fill(0);
    for (let num of nums) {
        count[num]++;
    }
    for (let c of count) {
        if (c % 2 !== 0) {
            return false;
        }
    }
    return true;
};
// @lc code=end

