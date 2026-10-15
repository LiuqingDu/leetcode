/*
 * @lc app=leetcode.cn id=1504 lang=javascript
 *
 * [1504] 统计全 1 子矩形
 */

// @lc code=start
/**
 * @param {number[][]} mat
 * @return {number}
 */
var numSubmat = function(mat) {
    
    const m = mat.length, n = mat[0].length;
    let res = 0;
    const row = new Array(m);
    for (let i = 0; i < m; i++) {
        row[i] = new Array(n).fill(0);
    }
    
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (j === 0) {
                row[i][j] = mat[i][j];
            } else {
                row[i][j] = mat[i][j] === 0 ? 0 : row[i][j - 1] + 1;
            }
            let cur = row[i][j];
            for (let k = i; k >= 0; k--) {
                cur = Math.min(cur, row[k][j]);
                if (cur === 0) {
                    break;
                }
                res += cur;
            }
        }
    }
    return res;

};
// @lc code=end

