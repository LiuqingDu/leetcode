/*
 * @lc app=leetcode.cn id=427 lang=javascript
 *
 * [427] 建立四叉树
 */

// @lc code=start
/**
 * // Definition for a QuadTree node.
 * function _Node(val,isLeaf,topLeft,topRight,bottomLeft,bottomRight) {
 *    this.val = val;
 *    this.isLeaf = isLeaf;
 *    this.topLeft = topLeft;
 *    this.topRight = topRight;
 *    this.bottomLeft = bottomLeft;
 *    this.bottomRight = bottomRight;
 * };
 */

/**
 * @param {number[][]} grid
 * @return {_Node}
 */
var construct = function(grid) {
    return constructQuadTree(grid, 0, 0, grid.length);
};

let constructQuadTree = function(grid, row, col, size) {
    // 如果是叶子节点，则直接返回
    if (isLeaf(grid, row, col, size)) {
        return new Node(grid[row][col] === 1, true);
    }
    
    // 划分为四个子区域
    const newSize = size / 2;
    const topLeft = constructQuadTree(grid, row, col, newSize);
    const topRight = constructQuadTree(grid, row, col + newSize, newSize);
    const bottomLeft = constructQuadTree(grid, row + newSize, col, newSize);
    const bottomRight = constructQuadTree(grid, row + newSize, col + newSize, newSize);
    
    // 返回包含四个子节点的父节点
    return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
}

// 检查当前区域是否为叶子节点
let isLeaf = function(grid, row, col, size) {
    const val = grid[row][col];
    for (let i = row; i < row + size; i++) {
        for (let j = col; j < col + size; j++) {
            if (grid[i][j] !== val) {
                return false;
            }
        }
    }
    return true;
}
// @lc code=end

