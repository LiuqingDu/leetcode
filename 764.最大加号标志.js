/*
 * @lc app=leetcode.cn id=764 lang=javascript
 *
 * [764] 最大加号标志
 */

// @lc code=start
/**
 * @param {number} n
 * @param {number[][]} mines
 * @return {number}
 */
var orderOfLargestPlusSign = function(n, mines) {
    
    // 1. 将地雷存入哈希表，使用普通的 "r_c" 字符串作为 key，简单直观
    const zeroSet = new Set();
    for (let i = 0; i < mines.length; i++) {
        zeroSet.add(mines[i][0] + '_' + mines[i][1]);
    }

    // 2. 初始化二维 dp 数组，全部填满最大可能的值 n
    const dp = [];
    for (let i = 0; i < n; i++) {
        dp[i] = new Array(n).fill(n);
    }

    let maxOrder = 0;

    // 3. 核心：双指针四方向同时扫描
    for (let i = 0; i < n; i++) {
        let left = 0, right = 0, up = 0, down = 0;

        for (let j = 0, k = n - 1; j < n; j++, k--) {
            // --- 行方向计算 ---
            // 从左往右 (i, j)
            left = zeroSet.has(i + '_' + j) ? 0 : left + 1;
            dp[i][j] = Math.min(dp[i][j], left);

            // 从右往左 (i, k)
            right = zeroSet.has(i + '_' + k) ? 0 : right + 1;
            dp[i][k] = Math.min(dp[i][k], right);

            // --- 列方向计算 ---
            // 从上往下 (j, i)
            up = zeroSet.has(j + '_' + i) ? 0 : up + 1;
            dp[j][i] = Math.min(dp[j][i], up);

            // 从下往上 (k, i)
            down = zeroSet.has(k + '_' + i) ? 0 : down + 1;
            dp[k][i] = Math.min(dp[k][i], down);
        }
    }

    // 4. 遍历二维数组，找出最大阶数
    for (let r = 0; r < n; r++) {
        for (let c = 0; c < n; c++) {
            if (dp[r][c] > maxOrder) {
                maxOrder = dp[r][c];
            }
        }
    }

    return maxOrder;
};
// @lc code=end

