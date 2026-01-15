/*
 * @lc app=leetcode.cn id=2788 lang=javascript
 *
 * [2788] 按分隔符拆分字符串
 */

// @lc code=start
/**
 * @param {string[]} words
 * @param {character} separator
 * @return {string[]}
 */
var splitWordsBySeparator = function(words, separator) {
    let res = [];
    for (let word of words) {
        res.push(...word.split(separator).filter((sub) => sub.length != 0));
    }
    return res;
};
// @lc code=end

