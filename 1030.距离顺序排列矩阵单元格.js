/*
 * @lc app=leetcode.cn id=1030 lang=javascript
 *
 * [1030] 距离顺序排列矩阵单元格
 */

// @lc code=start
/**
 * @param {number} rows
 * @param {number} cols
 * @param {number} rCenter
 * @param {number} cCenter
 * @return {number[][]}
 */
var allCellsDistOrder = function(rows, cols, rCenter, cCenter) {
    
    const result = [];

    // 1. 遍历矩阵，将所有单元格坐标 [r, c] 存入数组
    for (let r = 0; r < rows; r++) {
        for (let c = 0; c < cols; c++) {
            result.push([r, c]);
        }
    }

    // 2. 按照到中心点 (rCenter, cCenter) 的曼哈顿距离进行升序排序
    result.sort((cell1, cell2) => {
        // 计算第一个点到中心点的距离
        const dist1 = Math.abs(cell1[0] - rCenter) + Math.abs(cell1[1] - cCenter);
        // 计算第二个点到中心点的距离
        const dist2 = Math.abs(cell2[0] - rCenter) + Math.abs(cell2[1] - cCenter);
        
        // 升序排列：距离小的排在前面
        return dist1 - dist2;
    });

    // 3. 返回排序后的结果
    return result;
};
// @lc code=end

