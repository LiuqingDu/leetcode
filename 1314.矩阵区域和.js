/*
 * @lc app=leetcode.cn id=1314 lang=javascript
 *
 * [1314] 矩阵区域和
 */

// @lc code=start
/**
 * @param {number[][]} mat
 * @param {number} k
 * @return {number[][]}
 */
var matrixBlockSum = function(mat, k) {
    const m = mat.length;
    const n = mat[0].length;

    // 1. 前缀和数组（多一行一列方便处理边界）
    const pre = Array.from({ length: m + 1 }, () => Array(n + 1).fill(0));

    for (let i = 1; i <= m; i++) {
        for (let j = 1; j <= n; j++) {
            pre[i][j] =
                mat[i - 1][j - 1] +
                pre[i - 1][j] +
                pre[i][j - 1] -
                pre[i - 1][j - 1];
        }
    }

    const ans = Array.from({ length: m }, () => Array(n).fill(0));

    // 2. 每个点计算 k 范围矩形和
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {

            let r1 = Math.max(0, i - k);
            let c1 = Math.max(0, j - k);
            let r2 = Math.min(m - 1, i + k);
            let c2 = Math.min(n - 1, j + k);

            // 前缀和要 +1
            r1++; c1++; r2++; c2++;

            ans[i][j] =
                pre[r2][c2]
                - pre[r1 - 1][c2]
                - pre[r2][c1 - 1]
                + pre[r1 - 1][c1 - 1];
        }
    }

    return ans;
};
// @lc code=end

