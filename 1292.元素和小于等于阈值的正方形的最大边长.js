/*
 * @lc app=leetcode.cn id=1292 lang=javascript
 *
 * [1292] 元素和小于等于阈值的正方形的最大边长
 */

// @lc code=start
/**
 * @param {number[][]} mat
 * @param {number} threshold
 * @return {number}
 */
var maxSideLength = function(mat, threshold) {
    
    const m = mat.length;
    const n = mat[0].length;

    // 1️⃣ 构建前缀和数组
    const pre = Array.from({ length: m + 1 }, () => Array(n + 1).fill(0));

    for (let i = 1; i <= m; i++) {
        for (let j = 1; j <= n; j++) {
            pre[i][j] = mat[i - 1][j - 1]
                      + pre[i - 1][j]
                      + pre[i][j - 1]
                      - pre[i - 1][j - 1];
        }
    }

    let maxLen = 0;

    // 2️⃣ 枚举边长
    for (let len = 1; len <= Math.min(m, n); len++) {
        let found = false;

        for (let i = len; i <= m; i++) {
            for (let j = len; j <= n; j++) {

                // 3️⃣ 用前缀和快速算子矩阵
                const sum = pre[i][j]
                          - pre[i - len][j]
                          - pre[i][j - len]
                          + pre[i - len][j - len];

                if (sum <= threshold) {
                    found = true;
                    break;
                }
            }
            if (found) break;
        }

        if (found) {
            maxLen = len;
        } else {
            break; // 更大边长不可能成立
        }
    }

    return maxLen;
};
// @lc code=end

