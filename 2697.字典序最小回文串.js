/*
 * @lc app=leetcode.cn id=2697 lang=javascript
 *
 * [2697] 字典序最小回文串
 */

// @lc code=start
/**
 * @param {string} s
 * @return {string}
 */
var makeSmallestPalindrome = function(s) {
    s = s.split('');
    let left = 0, right = s.length - 1;
    while (left < right) {
        if (s[left] != s[right]) {
            if (s[left] < s[right]) {
                s[right] = s[left];
            } else {
                s[left] = s[right];
            }
        }
        ++left;
        --right;
    }
    return s.join('');
};
// @lc code=end

