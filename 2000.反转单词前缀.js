/*
 * @lc app=leetcode.cn id=2000 lang=javascript
 *
 * [2000] 反转单词前缀
 */

// @lc code=start
/**
 * @param {string} word
 * @param {character} ch
 * @return {string}
 */
var reversePrefix = function(word, ch) {
    let index = word.indexOf(ch);
    if (index === -1) {
        return word;
    }
    let prefix = word.slice(0, index + 1).split('').reverse().join('');
    return prefix + word.slice(index + 1);
};
// @lc code=end

