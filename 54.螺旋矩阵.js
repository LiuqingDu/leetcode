/*
 * @lc app=leetcode.cn id=54 lang=javascript
 *
 * [54] 螺旋矩阵
 */

// @lc code=start
/**
 * @param {number[][]} matrix
 * @return {number[]}
 */
var spiralOrder = function(matrix) {

    let m = matrix.length;
    let n = matrix[0].length;

    let total = m * n;
    let top = 0, bottom = m - 1, left = 0, right = n - 1;

    let res = [];

    while(res.length < total) {
        if (top <= bottom) {
            for (let j = left; j <= right; j++) {
                res.push(matrix[top][j]);
            }
            top++;
        }

        if (right >= left) {
            for (let i = top; i <= bottom; i++) {
                res.push(matrix[i][right]);
            }
            right--;
        }

        if (bottom >= top) {
            for (let j = right; j >= left; j--) {
                res.push(matrix[bottom][j]);
            }
            bottom--;
        }

        if (left <= right) {
            for (let i = bottom; i >= top; i--) {
                res.push(matrix[i][left]);
            }
            left++;
        }

    }

    return res;

};
// @lc code=end

