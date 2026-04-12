/*
 * @lc app=leetcode.cn id=1091 lang=javascript
 *
 * [1091] 二进制矩阵中的最短路径
 */

// @lc code=start
/**
 * @param {number[][]} grid
 * @return {number}
 */
var shortestPathBinaryMatrix = function(grid) {
    const n = grid.length;

    // 起点或终点不可走
    if (grid[0][0] !== 0 || grid[n - 1][n - 1] !== 0) {
        return -1;
    }

    // 8个方向
    const dirs = [
        [0,1], [1,0], [0,-1], [-1,0],
        [1,1], [1,-1], [-1,1], [-1,-1]
    ];

    // 队列：存 [x, y, 距离]
    const queue = [[0, 0, 1]];

    // 标记访问
    grid[0][0] = 1;

    while (queue.length) {
        const [x, y, dist] = queue.shift();

        // 到终点
        if (x === n - 1 && y === n - 1) {
            return dist;
        }

        for (const [dx, dy] of dirs) {
            const nx = x + dx;
            const ny = y + dy;

            // 判断是否合法
            if (
                nx >= 0 && ny >= 0 &&
                nx < n && ny < n &&
                grid[nx][ny] === 0
            ) {
                queue.push([nx, ny, dist + 1]);
                grid[nx][ny] = 1; // 标记访问
            }
        }
    }

    return -1;
};
// @lc code=end

