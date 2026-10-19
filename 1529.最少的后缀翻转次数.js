/*
 * @lc app=leetcode.cn id=1529 lang=javascript
 *
 * [1529] 最少的后缀翻转次数
 */

// @lc code=start
/**
 * @param {string} target
 * @return {number}
 */
var minFlips = function(target) {
    let flips = 0;
    let prev = '0';
    let n = target.length;
    for (let i = 0; i < n; i ++) {
        let curr = target.charAt(i)
        if (curr !== prev) {
            flips++;
            prev = curr;
        }
    }
    return flips;
};
// @lc code=end

