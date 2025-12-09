/*
 * @lc app=leetcode.cn id=2591 lang=javascript
 *
 * [2591] 将钱分给最多的儿童
 */

// @lc code=start
/**
 * @param {number} money
 * @param {number} children
 * @return {number}
 */
var distMoney = function(money, children) {
    if (money < children) {
        return -1;
    }
    money -= children
    let cnt = Math.min(Math.floor(money / 7), children);
    money -= cnt * 7;
    children -= cnt;
    if ((children == 0 && money > 0) || (children == 1 && money == 3)) {
        cnt -= 1;
    }
    return cnt;
};
// @lc code=end

