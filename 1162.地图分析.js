/*
 * @lc app=leetcode.cn id=1162 lang=javascript
 *
 * [1162] 地图分析
 */

// @lc code=start
/**
 * @param {number[][]} grid
 * @return {number}
 */
var maxDistance = function(grid) {
    
    const n = grid.length;
    const queue = [];
    
    // 1. 把所有陆地加入队列
    for (let i = 0; i < n; i++) {
        for (let j = 0; j < n; j++) {
            if (grid[i][j] === 1) {
                queue.push([i, j]);
            }
        }
    }

    // 特殊情况
    if (queue.length === 0 || queue.length === n * n) {
        return -1;
    }

    const dirs = [[1,0],[-1,0],[0,1],[0,-1]];
    let distance = -1;

    // 2. BFS
    while (queue.length > 0) {

        let size = queue.length;
        distance++;

        for (let i = 0; i < size; i++) {

            const [x, y] = queue.shift();

            for (const [dx, dy] of dirs) {

                const nx = x + dx;
                const ny = y + dy;

                if (
                    nx >= 0 && nx < n &&
                    ny >= 0 && ny < n &&
                    grid[nx][ny] === 0
                ) {
                    grid[nx][ny] = 1;
                    queue.push([nx, ny]);
                }
            }
        }
    }

    return distance;
};
// @lc code=end

