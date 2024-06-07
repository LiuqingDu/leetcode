/*
 * @lc app=leetcode.cn id=409 lang=javascript
 *
 * [409] 最长回文串
 */

// @lc code=start
/**
 * @param {string} s
 * @return {number}
 */
var longestPalindrome = function(s) {
    let res = 0;
    let arr = new Array(128).fill(0);
    for (let i = 0; i < s.length; i++) {
        arr[s.charCodeAt(i)]++;
        if (arr[s.charCodeAt(i)] % 2 === 0) {
            res+=2;
        }
    }
    if (res < s.length) {
        res++;
    }
    return res;

};
// @lc code=end

