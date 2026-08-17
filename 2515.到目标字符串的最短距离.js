/*
 * @lc app=leetcode.cn id=2515 lang=javascript
 *
 * [2515] 到目标字符串的最短距离
 */

// @lc code=start
/**
 * @param {string[]} words
 * @param {string} target
 * @param {number} startIndex
 * @return {number}
 */
var closestTarget = function(words, target, startIndex) {
    let res = words.length;
    let n = words.length;

    for (let i = 0; i < n; i++) {
        if (words[i] === target) {
            let dist = Math.abs(i - startIndex);
            res = Math.min(res, Math.min(dist, n - dist));
        }
    }

    return res < n ? res : -1;
};
// @lc code=end

