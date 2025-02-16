/*
 * @lc app=leetcode.cn id=1160 lang=javascript
 *
 * [1160] 拼写单词
 */

// @lc code=start
/**
 * @param {string[]} words
 * @param {string} chars
 * @return {number}
 */
var countCharacters = function(words, chars) {
    let canForm = function(word, map) {
        let count = new Array(26).fill(0);
        for (let c of word) {
            let index = c.charCodeAt() - 97;
            count[index]++;
            if (count[index] > map[index]) return false;
        }
        return true;
    };

    let map = new Array(26).fill(0);
    for (let c of chars) {
        map[c.charCodeAt() - 97]++;
    }

    let sum = 0;
    for (let word of words) {
        if (canForm(word, map)) {
            sum += word.length;
        }
    }
    return sum;
};
// @lc code=end

