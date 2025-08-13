/*
 * @lc app=leetcode.cn id=2108 lang=javascript
 *
 * [2108] 找出数组中的第一个回文字符串
 */

// @lc code=start
/**
 * @param {string[]} words
 * @return {string}
 */
var firstPalindrome = function(words) {
    let isPalindrome = (word) => {
        let left = 0, right = word.length - 1;
        while (left < right) {
            if (word[left] !== word[right]) return false;
            left++;
            right--;
        }
        return true;
    };
    for (let word of words) {
        if (isPalindrome(word)) {
            return word;
        }
    }
    return '';
};
// @lc code=end

