/*
 * @lc app=leetcode.cn id=125 lang=javascript
 *
 * [125] 验证回文串
 */

// @lc code=start
/**
 * @param {string} s
 * @return {boolean}
 */
var isPalindrome = function(s) {

    let valid = function(c) {
        return (c >= "a" && c <= "z") || (c >= "A" && c <= "Z") || (c >= "0" && c <= "9");
    }

    s = s.toLowerCase();

    let i = 0; j = s.length - 1;

    while (i < j) {
        while (!valid(s.charAt(i)) && i < j) {
            i++;
        }
        while (!valid(s.charAt(j)) && i < j) {
            j--;
        }

        if (i < j) {

            if (s.charAt(i) !== s.charAt(j)) {
                return false;
            }
            
            i++;
            j--;
        }
    }

    return true;

};
// @lc code=end

