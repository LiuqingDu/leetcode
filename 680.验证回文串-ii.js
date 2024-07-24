/*
 * @lc app=leetcode.cn id=680 lang=javascript
 *
 * [680] 验证回文串 II
 */

// @lc code=start
/**
 * @param {string} s
 * @return {boolean}
 */
var validPalindrome = function(s) {
    let isPalindrome = function(s, l, r) {
        while (l < r) {
            if (s.charAt(l) !== s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    let l = 0, r = s.length - 1;
    while (l < r) {
        if (s.charAt(l) != s.charAt(r)) {
            return isPalindrome(s, l + 1, r) || isPalindrome(s, l, r - 1);
        }
        l++;
        r--;
    }
    return true;
};
// @lc code=end

