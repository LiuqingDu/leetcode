/*
 * @lc app=leetcode.cn id=2194 lang=javascript
 *
 * [2194] Excel 表中某个范围内的单元格
 */

// @lc code=start
/**
 * @param {string} s
 * @return {string[]}
 */
var cellsInRange = function(s) {
    const result = [];
    const startCol = s.charCodeAt(0) - 'A'.charCodeAt(0);
    const endCol = s.charCodeAt(3) - 'A'.charCodeAt(0);
    const startRow = s.charCodeAt(1) - '0'.charCodeAt(0);
    const endRow = s.charCodeAt(4) - '0'.charCodeAt(0);

    for (let col = startCol; col <= endCol; col++) {
        for (let row = startRow; row <= endRow; row++) {
            result.push(`${String.fromCharCode(col + 'A'.charCodeAt(0))}${row}`);
        }
    }
    return result;
};
// @lc code=end

