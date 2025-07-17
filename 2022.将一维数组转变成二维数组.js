/*
 * @lc app=leetcode.cn id=2022 lang=javascript
 *
 * [2022] 将一维数组转变成二维数组
 */

// @lc code=start
/**
 * @param {number[]} original
 * @param {number} m
 * @param {number} n
 * @return {number[][]}
 */
var construct2DArray = function(original, m, n) {
    if (m * n !== original.length) {
        return [];
    }
    const result = new Array(m).fill(0).map(() => new Array(n).fill(0));
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            result[i][j] = original[i * n + j];
        }
    }
    return result;
};
// @lc code=end

