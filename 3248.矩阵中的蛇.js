/*
 * @lc app=leetcode.cn id=3248 lang=javascript
 *
 * [3248] 矩阵中的蛇
 */

// @lc code=start
/**
 * @param {number} n
 * @param {string[]} commands
 * @return {number}
 */
var finalPositionOfSnake = function(n, commands) {
    
    let ans = 0;
    for (const c of commands) {
        if (c[0] === 'U') {
            ans -= n;
        } else if (c[0] === 'D') {
            ans += n;
        } else if (c[0] === 'L') {
            ans--;
        } else {
            ans++;
        }
    }
    return ans;

};
// @lc code=end

