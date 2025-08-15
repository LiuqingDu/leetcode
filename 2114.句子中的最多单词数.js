/*
 * @lc app=leetcode.cn id=2114 lang=javascript
 *
 * [2114] 句子中的最多单词数
 */

// @lc code=start
/**
 * @param {string[]} sentences
 * @return {number}
 */
var mostWordsFound = function(sentences) {
    let res = 0;
    for (let sentence of sentences) {
        let words = sentence.split(" ");
        res = Math.max(res, words.length);
    }
    return res;
};
// @lc code=end

