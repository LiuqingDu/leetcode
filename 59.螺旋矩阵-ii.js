/*
 * @lc app=leetcode.cn id=59 lang=javascript
 *
 * [59] 螺旋矩阵 II
 */

// @lc code=start
/**
 * @param {number} n
 * @return {number[][]}
 */
var generateMatrix = function(n) {

    let res = [];

    for (let i = 0; i < n; i++) {
        res[i] = [];
    }

    let m = 1;
    let top = 0, bottom = n - 1, left = 0; right = n - 1;

    while (m <= n*n) {
        if (top <= bottom) {
            for (let j = left; j <= right; j++) {
                res[top][j] = m;
                m++;
            }
            top++;
        }

        if (right >= left) {
            for (let i = top; i <= bottom; i++) {
                res[i][right] = m;
                m++;
            }
            right--;
        }

        if (bottom >= top) {
            for (let j = right; j >= left; j--) {
                res[bottom][j] = m;
                m++;
            }
            bottom--;
        }

        if (left <= right) {
            for (let i = bottom; i >= top; i--) {
                res[i][left] = m;
                m++;
            }
            left++;
        }
    }

    return res;

};
// @lc code=end

