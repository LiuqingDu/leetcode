/*
 * @lc app=leetcode.cn id=1859 lang=javascript
 *
 * [1859] 将句子排序
 */

// @lc code=start
/**
 * @param {string} s
 * @return {string}
 */
var sortSentence = function(s) {
    const words = s.split(" ");
    const result = Array(words.length);

    for (let word of words) {
        const index = parseInt(word[word.length - 1]) - 1;
        result[index] = word.slice(0, -1);
    }

    return result.join(" ");
};
// @lc code=end

