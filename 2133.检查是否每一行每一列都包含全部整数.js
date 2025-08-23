/*
 * @lc app=leetcode.cn id=2133 lang=javascript
 *
 * [2133] 检查是否每一行每一列都包含全部整数
 */

// @lc code=start
/**
 * @param {number[][]} matrix
 * @return {boolean}
 */
var checkValid = function(matrix) {
    const n = matrix.length;
    
    for (let i = 0; i < n; i++) {
        const rowSet = new Set();
        const colSet = new Set();
        for (let j = 0; j < n; j++) {
            rowSet.add(matrix[i][j]);
            colSet.add(matrix[j][i]);
        }
        // 如果都出现过,则集合的大小应该等于 n
        if (rowSet.size !== n || colSet.size !== n) {
            return false;
        }
    }
    return true;
};
// @lc code=end

