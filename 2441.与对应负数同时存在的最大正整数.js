/*
 * @lc app=leetcode.cn id=2441 lang=javascript
 *
 * [2441] 与对应负数同时存在的最大正整数
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var findMaxK = function(nums) {
    let k = -1;
    for (const x of nums) {
        for (const y of nums) {
            if (-x === y) {
                k = Math.max(k, x);
            }
        }
    }
    return k;
};
// @lc code=end

