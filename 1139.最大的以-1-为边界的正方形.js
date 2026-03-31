/*
 * @lc app=leetcode.cn id=1139 lang=javascript
 *
 * [1139] 最大的以 1 为边界的正方形
 */

// @lc code=start
/**
 * @param {number[][]} grid
 * @return {number}
 */
var largest1BorderedSquare = function(grid) {
    
    const m = grid.length;
    const n = grid[0].length;

    // 初始化
    const right = Array.from({ length: m }, () => Array(n).fill(0));
    const down = Array.from({ length: m }, () => Array(n).fill(0));

    // 预处理（从右下往左上）
    for (let i = m - 1; i >= 0; i--) {
        for (let j = n - 1; j >= 0; j--) {
            if (grid[i][j] === 1) {
                right[i][j] = 1 + (j + 1 < n ? right[i][j + 1] : 0);
                down[i][j] = 1 + (i + 1 < m ? down[i + 1][j] : 0);
            }
        }
    }

    let maxLen = 0;

    // 枚举左上角
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {

            // 从大到小试（关键剪枝）
            for (let k = Math.min(m - i, n - j); k > 0; k--) {

                if (k <= maxLen) break;

                if (
                    right[i][j] >= k &&
                    down[i][j] >= k &&
                    right[i + k - 1][j] >= k &&
                    down[i][j + k - 1] >= k
                ) {
                    maxLen = k;
                    break;
                }
            }
        }
    }

    return maxLen * maxLen;
};
// @lc code=end

