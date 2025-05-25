/*
 * @lc app=leetcode.cn id=1812 lang=javascript
 *
 * [1812] 判断国际象棋棋盘中一个格子的颜色
 */

// @lc code=start
/**
 * @param {string} coordinates
 * @return {boolean}
 */
var squareIsWhite = function(coordinates) {
    return ((coordinates[0].charCodeAt() - 'a'.charCodeAt() + 1) + (coordinates[1].charCodeAt() - '0'.charCodeAt())) % 2 === 1;
};
// @lc code=end

