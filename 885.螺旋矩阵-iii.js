/*
 * @lc app=leetcode.cn id=885 lang=javascript
 *
 * [885] 螺旋矩阵 III
 */

// @lc code=start
/**
 * @param {number} rows
 * @param {number} cols
 * @param {number} rStart
 * @param {number} cStart
 * @return {number[][]}
 */
var spiralMatrixIII = function (rows, cols, rStart, cStart) {
    const directions = [[0, 1], [1, 0], [0, -1], [-1, 0]];
    const result = Array(rows * cols);
    let r = rStart, c = cStart;
    let dirIndex = 0, step = 1, index = 0, visited = 0, total = rows * cols;
    if (r >= 0 && r < rows && c >= 0 && c < cols) {
        result[index++] = [r, c];
        visited++;
    }
    while (visited < total) {
        for (let i = 0; i < 2; i++) {
            for (let j = 0; j < step; j++) {
                r += directions[dirIndex][0];
                c += directions[dirIndex][1];
                if (r >= 0 && r < rows && c >= 0 && c < cols) {
                    result[index++] = [r, c];
                    visited++;
                    if (visited === total) return result;
                }
            }
            dirIndex = (dirIndex + 1) % 4;
        }
        step++;
    }
    return result;
};
// @lc code=end

