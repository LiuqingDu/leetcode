/*
 * @lc app=leetcode.cn id=934 lang=javascript
 *
 * [934] 最短的桥
 */

// @lc code=start
/**
 * @param {number[][]} grid
 * @return {number}
 */
var shortestBridge = function(grid) {
    
    const n = grid.length;
    const queue = [];
    const dirs = [[1,0], [-1,0], [0,1], [0,-1]];

    // ===== 1. DFS 找第一个岛 =====
    function dfs(i, j) {
        // 越界 or 不是1
        if (i < 0 || j < 0 || i >= n || j >= n || grid[i][j] !== 1) return;

        grid[i][j] = 2; // 标记为已访问
        queue.push([i, j]);

        for (let [dx, dy] of dirs) {
            dfs(i + dx, j + dy);
        }
    }

    // 找到第一个岛并标记
    let found = false;
    for (let i = 0; i < n && !found; i++) {
        for (let j = 0; j < n && !found; j++) {
            if (grid[i][j] === 1) {
                dfs(i, j);
                found = true;
            }
        }
    }

    // ===== 2. BFS 扩散 =====
    let step = 0;

    while (queue.length > 0) {
        let size = queue.length;

        for (let k = 0; k < size; k++) {
            const [x, y] = queue.shift();

            for (let [dx, dy] of dirs) {
                const nx = x + dx;
                const ny = y + dy;

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;

                if (grid[nx][ny] === 1) {
                    return step; // 找到第二个岛
                }

                if (grid[nx][ny] === 0) {
                    grid[nx][ny] = 2;
                    queue.push([nx, ny]);
                }
            }
        }

        step++;
    }

    return -1;
};
// @lc code=end

