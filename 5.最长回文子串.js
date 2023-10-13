/*
 * @lc app=leetcode.cn id=5 lang=javascript
 *
 * [5] 最长回文子串
 */

// @lc code=start
/**
 * @param {string} s
 * @return {string}
 */
var longestPalindrome = function(s) {
    let res = "";
    let n = s.length;

    for (let i = 0; i < n; i++) {
        let str1 = palindrome(s, i, i);
        let str2 = palindrome(s, i, i+1);
        if (str1.length > res.length) {
            res = str1;
        }
        if (str2.length > res.length) {
            res = str2;
        }
    }
    return res;
};

let palindrome = function(s, l, r) {
    let n = s.length;
    while(l >= 0 && l < n && r >= 0 && r < n && s.charAt(l) === s.charAt(r)) {
        l--;
        r++;
    }

    return s.substring(l+1, r);
}
// @lc code=end

