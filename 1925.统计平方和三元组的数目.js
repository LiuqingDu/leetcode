/*
 * @lc app=leetcode.cn id=1925 lang=javascript
 *
 * [1925] 统计平方和三元组的数目
 */

// @lc code=start
/**
 * @param {number} n
 * @return {number}
 */
var countTriples = function(n) {
    let count = 0;
    for (let a = 1; a <= n; a++) {
        for (let b = 1; b <= n; b++) {
            let sum = a * a + b * b;
            let c = Math.sqrt(sum);
            if (Number.isInteger(c) && c <= n) {
                count++;
            }
        }
    }
    return count;
};
// @lc code=end

