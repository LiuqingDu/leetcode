/*
 * @lc app=leetcode.cn id=884 lang=javascript
 *
 * [884] 两句话中的不常见单词
 */

// @lc code=start
/**
 * @param {string} s1
 * @param {string} s2
 * @return {string[]}
 */
var uncommonFromSentences = function(s1, s2) {
    let str = s1 + " " + s2;
    let words = str.split(" ");
    let map = new Map();
    for (let word of words) {
        map.set(word, (map.get(word) || 0) + 1);
    }
    let res = [];
    for (let [k, v] of map.entries()) {
        if (v === 1) {
            res.push(k);
        }
    }
    return res;
};
// @lc code=end

