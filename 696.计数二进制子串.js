/*
 * @lc app=leetcode.cn id=696 lang=javascript
 *
 * [696] 计数二进制子串
 */

// @lc code=start
/**
 * @param {string} s
 * @return {number}
 */
var countBinarySubstrings = function(s) {
    let i = 0, n = s.length;
    let arr = [];
    while (i < n) {
        let c = s[i];
        let count = 0;
        while (i < n && s[i] == c) {
            count++;
            i++;
        }
        arr.push(count);
    }
    let res = 0;
    for (let i = 1; i < arr.length; i++) {
        res += Math.min(arr[i - 1], arr[i]);
    }
    return res;
};
// @lc code=end

