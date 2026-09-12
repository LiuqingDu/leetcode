/*
 * @lc app=leetcode.cn id=3289 lang=javascript
 *
 * [3289] 数字小镇中的捣蛋鬼
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number[]}
 */
var getSneakyNumbers = function(nums) {
    
    const res = [];
    const count = new Map();
    for (const x of nums) {
        count.set(x, (count.get(x) || 0) + 1);
        if (count.get(x) === 2) {
            res.push(x);
        }
    }
    return res;

};
// @lc code=end

