/*
 * @lc app=leetcode.cn id=3033 lang=javascript
 *
 * [3033] 修改矩阵
 */

// @lc code=start
/**
 * @param {number[][]} matrix
 * @return {number[][]}
 */
var modifiedMatrix = function(matrix) {
    
    const m = matrix.length;
    const n = matrix[0].length;

    // 1. 复制矩阵
    const answer = Array.from({ length: m }, () => Array(n));
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            answer[i][j] = matrix[i][j];
        }
    }

    // 2. 每一列找最大值
    for (let j = 0; j < n; j++) {
        let max = -1;

        for (let i = 0; i < m; i++) {
            max = Math.max(max, matrix[i][j]);
        }

        // 3. 替换 -1
        for (let i = 0; i < m; i++) {
            if (answer[i][j] === -1) {
                answer[i][j] = max;
            }
        }
    }

    return answer;
};
// @lc code=end

