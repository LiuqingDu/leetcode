/*
 * @lc app=leetcode.cn id=378 lang=javascript
 *
 * [378] 有序矩阵中第 K 小的元素
 */

// @lc code=start
/**
 * @param {number[][]} matrix
 * @param {number} k
 * @return {number}
 */
var kthSmallest = function(matrix, k) {
    let check = function(matrix, mid, k, n) {
        let i = n - 1;
        let j = 0;
        let num = 0;
    
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= mid) {
                num += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return num >= k;
    }
    
    let n = matrix.length;
    let left = matrix[0][0];
    let right = matrix[n - 1][n - 1];

    while (left < right) {
        let mid = left + ((right - left) >> 1);
        if (check(matrix, mid, k, n)) {
            right = mid;
        } else {
            left = mid + 1;
        }
    }
    return left;
};
// @lc code=end

