/*
 * @lc app=leetcode.cn id=861 lang=javascript
 *
 * [861] 翻转矩阵后的得分
 */

// @lc code=start
/**
 * @param {number[][]} grid
 * @return {number}
 */
var matrixScore = function(grid) {
    const m = grid.length, n = grid[0].length;
    let ret = m * (1 << (n - 1));

    for (let j = 1; j < n; j++) {
        let nOnes = 0;
        for (let i = 0; i < m; i++) {
            if (grid[i][0] === 1) {
                nOnes += grid[i][j];
            } else {
                nOnes += (1 - grid[i][j]); // 如果这一行进行了行反转，则该元素的实际取值为 1 - grid[i][j]
            }
        }
        const k = Math.max(nOnes, m - nOnes);
        ret += k * (1 << (n - j - 1));
    }
    return ret;
};
// @lc code=end

