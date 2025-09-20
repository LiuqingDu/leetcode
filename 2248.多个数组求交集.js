/*
 * @lc app=leetcode.cn id=2248 lang=javascript
 *
 * [2248] 多个数组求交集
 */

// @lc code=start
/**
 * @param {number[][]} nums
 * @return {number[]}
 */
var intersection = function(nums) {
    const n = nums.length;
    const map = new Map();
    const flatArray = nums.flat()
    for (let num of flatArray) {
        map.set(num, (map.get(num) || 0) + 1);
    }
    const res = [];
    for (let [num, count] of map) {
        if (count === n) {
            res.push(num);
        }
    }
    return res.sort((a, b) => a - b);
};
// @lc code=end

