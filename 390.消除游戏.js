/*
 * @lc app=leetcode.cn id=390 lang=javascript
 *
 * [390] 消除游戏
 */

// @lc code=start
/**
 * @param {number} n
 * @return {number}
 */
var lastRemaining = function(n) {

    let head = 1;
    let step = 1;
    let left = true;

    while (n > 1) {
        if (left || n % 2 !== 0) {
            head += step;
        }
        step *= 2;
        left =  !left;
        n = Math.floor(n / 2);
    }

    return head;

};
// @lc code=end

