/*
 * @lc app=leetcode.cn id=1886 lang=javascript
 *
 * [1886] 判断矩阵经轮转后是否一致
 */

// @lc code=start
/**
 * @param {number[][]} mat
 * @param {number[][]} target
 * @return {boolean}
 */
var findRotation = function(mat, target) {
    let isSame = function(mat1, mat2) {
        const n = mat1.length;
        for (let i = 0; i < n; i++) {
            for (let j = 0; j < n; j++) {
                if (mat1[i][j] !== mat2[i][j]) return false;
            }
        }
        return true;
    }

    let rotate = function(mat) {
        const n = mat.length;
        const rotated = Array.from({ length: n }, () => Array(n).fill(0));
        for (let i = 0; i < n; i++) {
            for (let j = 0; j < n; j++) {
                rotated[j][n - 1 - i] = mat[i][j];
            }
        }
        return rotated;
    }

    for (let i = 0; i < 4; i++) {
        if (isSame(mat, target)) return true;
        mat = rotate(mat);
    }
    return false;
};
// @lc code=end

