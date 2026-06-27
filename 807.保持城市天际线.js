/*
 * @lc app=leetcode.cn id=807 lang=javascript
 *
 * [807] 保持城市天际线
 */

// @lc code=start
/**
 * @param {number[][]} grid
 * @return {number}
 */
var maxIncreaseKeepingSkyline = function(grid) {
    
    const n = grid.length;
    const rowMax = new Array(n).fill(0);
    const colMax = new Array(n).fill(0);

    // Step 1: 找出每一行和每一列的最大高度
    for (let r = 0; r < n; r++) {
        for (let c = 0; c < n; c++) {
            rowMax[r] = Math.max(rowMax[r], grid[r][c]);
            colMax[c] = Math.max(colMax[c], grid[r][c]);
        }
    }

    let totalIncrement = 0;

    // Step 2: 计算每个建筑最多能加高多少，并累加增量
    for (let r = 0; r < n; r++) {
        for (let c = 0; c < n; c++) {
            // 当前位置允许的最大高度是行最大和列最大中的【较小值】
            const maxAllowed = Math.min(rowMax[r], colMax[c]);
            totalIncrement += maxAllowed - grid[r][c];
        }
    }

    return totalIncrement;
};
// @lc code=end

