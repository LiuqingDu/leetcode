/*
 * @lc app=leetcode.cn id=576 lang=javascript
 *
 * [576] 出界的路径数
 */

// @lc code=start
/**
 * @param {number} m
 * @param {number} n
 * @param {number} maxMove
 * @param {number} startRow
 * @param {number} startColumn
 * @return {number}
 */
var findPaths = function(m, n, maxMove, startRow, startColumn) {
    const MOD = 1e9 + 7;
    const dirs = [[1, 0], [-1, 0], [0, 1], [0, -1]];
    let cache = Array.from({ length: m }, () => 
        Array.from({ length: n }, () => 
            Array(maxMove + 1).fill(-1)
        )
    );

    let dfs = function(x, y, k) {
        if (x < 0 || x >= m || y < 0 || y >= n) {
            return 1;
        }
        if (k === 0) {
            return 0;
        }
        if (cache[x][y][k] !== -1) {
            return cache[x][y][k];
        }
        let ans = 0;
        for (const [dx, dy] of dirs) {
            ans = (ans + dfs(x + dx, y + dy, k - 1)) % MOD;
        }
        cache[x][y][k] = ans;
        return ans;
    }

    return dfs(startRow, startColumn, maxMove);
};
// @lc code=end

