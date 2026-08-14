/*
 * @lc app=leetcode.cn id=2942 lang=javascript
 *
 * [2942] 查找包含给定字符的单词
 */

// @lc code=start
/**
 * @param {string[]} words
 * @param {character} x
 * @return {number[]}
 */
var findWordsContaining = function(words, x) {
    let res = [];
    let n = words.length;
    for (let i = 0; i < n; i++) {
        if (words[i].indexOf(x) !== -1) {
            res.push(i);
        }
    }
    return res;
};
// @lc code=end

