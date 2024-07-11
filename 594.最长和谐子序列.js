/*
 * @lc app=leetcode.cn id=594 lang=javascript
 *
 * [594] 最长和谐子序列
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var findLHS = function(nums) {
    let map = new Map();
    for (let n of nums) {
        map.set(n, (map.get(n) || 0) + 1);
    }
    let res = 0;
    for (let n of nums) {
        if (map.has(n - 1)) {
            res = Math.max(res, map.get(n) + map.get(n - 1));
        }
    }
    return res;
};
// @lc code=end

