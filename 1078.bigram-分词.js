/*
 * @lc app=leetcode.cn id=1078 lang=javascript
 *
 * [1078] Bigram 分词
 */

// @lc code=start
/**
 * @param {string} text
 * @param {string} first
 * @param {string} second
 * @return {string[]}
 */
var findOcurrences = function(text, first, second) {
    const words = text.split(" ");
    const list = [];
    for (let i = 2; i < words.length; i++) {
        if (words[i - 2] === first && words[i - 1] === second) {
            list.push(words[i]);
        }
    }
    const size = list.length;
    const ret = Array(size).fill('');
    for (let i = 0; i < size; i++) {
        ret[i] = list[i];
    }
    return ret;
};
// @lc code=end

