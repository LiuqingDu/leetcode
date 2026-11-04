/*
 * @lc app=leetcode.cn id=3222 lang=javascript
 *
 * [3222] 求出硬币游戏的赢家
 */

// @lc code=start
/**
 * @param {number} x
 * @param {number} y
 * @return {string}
 */
var winningPlayer = function(x, y) {
    let ops = Math.min(x, Math.floor(y / 4));
    return ops % 2 === 1 ? "Alice" : "Bob";
};
// @lc code=end

