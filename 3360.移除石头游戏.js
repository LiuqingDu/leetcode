/*
 * @lc app=leetcode.cn id=3360 lang=javascript
 *
 * [3360] 移除石头游戏
 */

// @lc code=start
/**
 * @param {number} n
 * @return {boolean}
 */
var canAliceWin = function(n) {
    let pick = 10;
    while (n >= pick) {
        n -= pick;
        pick--;
    }
    return (10 - pick) % 2 > 0;
};
// @lc code=end

