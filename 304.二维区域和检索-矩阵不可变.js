/*
 * @lc app=leetcode.cn id=304 lang=javascript
 *
 * [304] 二维区域和检索 - 矩阵不可变
 */

// @lc code=start
/**
 * @param {number[][]} matrix
 */
var NumMatrix = function(matrix) {

    let m = matrix.length;
    let n = matrix[0].length;

    this.sums = Array.from(Array(m), () => []);

    let s = 0;
    for (let i = 0; i < m; i++) {
        s += matrix[i][0];
        this.sums[i][0] = s;
    }
    s = 0;
    for (let i = 0; i < n; i++) {
        s += matrix[0][i];
        this.sums[0][i] = s;
    }

    for (let i = 1; i < m; i++) {
        for (let j = 1; j < n; j++) {
            this.sums[i][j] = this.sums[i - 1][j] + this.sums[i][j - 1] - this.sums[i - 1][j - 1] + matrix[i][j];
        }
    }

};

/** 
 * @param {number} row1 
 * @param {number} col1 
 * @param {number} row2 
 * @param {number} col2
 * @return {number}
 */
NumMatrix.prototype.sumRegion = function(row1, col1, row2, col2) {

    let left = 0, top = 0, leftTop = 0;
    if (row1 === 0) {
    } else {
        top = this.sums[row1 - 1][col2];
    }
    if (col1 === 0) {
    } else {
        left = this.sums[row2][col1 - 1];
    }
    if (row1 === 0 || col1 === 0) {
    } else {
        leftTop = this.sums[row1 - 1][col1 - 1];
    }
    return this.sums[row2][col2] - top - left + leftTop;
};

/**
 * Your NumMatrix object will be instantiated and called as such:
 * var obj = new NumMatrix(matrix)
 * var param_1 = obj.sumRegion(row1,col1,row2,col2)
 */
// @lc code=end

