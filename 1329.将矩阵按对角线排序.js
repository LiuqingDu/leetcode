/*
 * @lc app=leetcode.cn id=1329 lang=javascript
 *
 * [1329] 将矩阵按对角线排序
 */

// @lc code=start
/**
 * @param {number[][]} mat
 * @return {number[][]}
 */
var diagonalSort = function(mat) {
    const m = mat.length;
    const n = mat[0].length;

    // key: i-j
    // value: 对角线元素数组
    const map = new Map();

    // 1. 收集元素
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {

            const key = i - j;

            if (!map.has(key)) {
                map.set(key, []);
            }

            map.get(key).push(mat[i][j]);
        }
    }

    // 2. 每条对角线排序（降序）
    for (const arr of map.values()) {
        arr.sort((a, b) => b - a);
    }

    // 3. 放回矩阵
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {

            const key = i - j;

            // 取最后一个最小值
            mat[i][j] = map.get(key).pop();
        }
    }

    return mat;
};
// @lc code=end

