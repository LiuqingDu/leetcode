/*
 * @lc app=leetcode.cn id=3274 lang=javascript
 *
 * [3274] 检查棋盘方格颜色是否相同
 */

// @lc code=start
/**
 * @param {string} coordinate1
 * @param {string} coordinate2
 * @return {boolean}
 */
var checkTwoChessboards = function(coordinate1, coordinate2) {
        return (coordinate1.charCodeAt(0) - coordinate2.charCodeAt(0) + coordinate1.charCodeAt(1) - coordinate2.charCodeAt(1)) % 2 === 0;
};
// @lc code=end

