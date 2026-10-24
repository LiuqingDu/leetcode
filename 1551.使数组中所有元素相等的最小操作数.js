/*
 * @lc app=leetcode.cn id=1551 lang=javascript
 *
 * [1551] 使数组中所有元素相等的最小操作数
 */

// @lc code=start
/**
 * @param {number} n
 * @return {number}
 */
var minOperations = function(n) {
    let res = 0, avg = n;
    for (let i = 0; i < n; i++) {
        let x = 2 * i + 1;
        if (x > n) {
            res += x - n;
        }
    }
    return res;
};
// @lc code=end

