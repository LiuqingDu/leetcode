/*
 * @lc app=leetcode.cn id=2418 lang=javascript
 *
 * [2418] 按身高排序
 */

// @lc code=start
/**
 * @param {string[]} names
 * @param {number[]} heights
 * @return {string[]}
 */
var sortPeople = function(names, heights) {
    const n = names.length;
    const indices = Array.from({length: n}, (_, i) => i);
    indices.sort((a, b) => heights[b] - heights[a]);
    const res = new Array(n);
    for (let i = 0; i < n; i++) {
        res[i] = names[indices[i]];
    }
    return res;
};
// @lc code=end

