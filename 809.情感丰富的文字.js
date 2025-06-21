/*
 * @lc app=leetcode.cn id=809 lang=javascript
 *
 * [809] 情感丰富的文字
 */

// @lc code=start
/**
 * @param {string} s
 * @param {string[]} words
 * @return {number}
 */
var expressiveWords = function(s, words) {
    const isStretchy = (s, word) => {
        if (s.length < word.length) return false;
        let i = 0, j = 0;
        while (i < s.length && j < word.length) {
            if (s[i] !== word[j]) return false;
            let countS = 0, countWord = 0;
            while (i < s.length && s[i] === word[j]) {
                countS++;
                i++;
            }
            while (j < word.length && word[j] === s[i - 1]) {
                countWord++;
                j++;
            }
            if (countS < countWord || (countS < 3 && countS !== countWord)) return false;
        }
        return i === s.length && j === word.length;
    };

    return words.reduce((count, word) => count + isStretchy(s, word), 0);
};
// @lc code=end

