/*
 * @lc app=leetcode.cn id=2011 lang=javascript
 *
 * [2011] 执行操作后的变量值
 */

// @lc code=start
/**
 * @param {string[]} operations
 * @return {number}
 */
var finalValueAfterOperations = function(operations) {
    let x = 0;
    for (const operation of operations) {
        if (operation[1] === '+') {
            x++;
        } else if (operation[1] === '-') {
            x--;
        }
    }
    return x;
};
// @lc code=end

