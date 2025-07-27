/*
 * @lc app=leetcode.cn id=2053 lang=javascript
 *
 * [2053] 数组中第 K 个独一无二的字符串
 */

// @lc code=start
/**
 * @param {string[]} arr
 * @param {number} k
 * @return {string}
 */
var kthDistinct = function(arr, k) {
    const count = {};
    for (const str of arr) {
        count[str] = (count[str] || 0) + 1;
    }
    for (const str of arr) {
        if (count[str] === 1) {
            k--;
            if (k === 0) {
                return str;
            }
        }
    }
    return "";
};
// @lc code=end

