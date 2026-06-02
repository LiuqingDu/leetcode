/*
 * @lc app=leetcode.cn id=1391 lang=javascript
 *
 * [1391] 检查网格中是否存在有效路径
 */

// @lc code=start
/**
 * @param {number[][]} grid
 * @return {boolean}
 */
var hasValidPath = function(grid) {
    
    const m = grid.length;
    const n = grid[0].length;

    // 1. 定义 1~6 号街道的移动方向 [rowOffset, colOffset]
    // 下标 0 空置，方便与题目中的 1-6 数字直接对应
    const dirs = [
        [],                               // 0 空置
        [[0, -1], [0, 1]],                // 1: 左, 右
        [[-1, 0], [1, 0]],                // 2: 上, 下
        [[0, -1], [1, 0]],                // 3: 左, 下
        [[0, 1],  [1, 0]],                // 4: 右, 下
        [[0, -1], [-1, 0]],               // 5: 左, 上
        [[0, 1],  [-1, 0]]                // 6: 右, 上
    ];

    // 2. 辅助函数：判断目标格子 (nextR, nextC) 是否有开口通往出发点 (fromR, fromC)
    const canConnect = (nextR, nextC, fromR, fromC) => {
        const nextType = grid[nextR][nextC];
        // 遍历目标格子的两个开口
        for (const [dr, dc] of dirs[nextType]) {
            if (nextR + dr === fromR && nextC + dc === fromC) {
                return true;
            }
        }
        return false;
    };

    // 3. 初始化访问标记矩阵（默认全为 false）
    const visited = Array.from({ length: m }, () => new Array(n).fill(false));
    
    // 4. BFS 队列，存储坐标 [row, col]
    const queue = [];
    
    // 从左上角 (0, 0) 出发
    queue.push([0, 0]);
    visited[0][0] = true;

    while (queue.length > 0) {
        const [r, c] = queue.shift();

        // 如果成功到达右下角终点，返回 true
        if (r === m - 1 && c === n - 1) {
            return true;
        }

        const streetType = grid[r][c];

        // 尝试从当前格子的两个开口方向走出去
        for (const [dr, dc] of dirs[streetType]) {
            const nextR = r + dr;
            const nextC = c + dc;

            // 检查边界条件
            if (nextR >= 0 && nextR < m && nextC >= 0 && nextC < n) {
                // 如果没访问过，且对方格子和当前格子能“接通”
                if (!visited[nextR][nextC] && canConnect(nextR, nextC, r, c)) {
                    visited[nextR][nextC] = true;
                    queue.push([nextR, nextC]);
                }
            }
        }
    }

    // 队列空了还没找到终点，说明无路可走
    return false;
};
// @lc code=end

