/*
 * @lc app=leetcode.cn id=1935 lang=javascript
 *
 * [1935] 可以输入的最大单词数
 */

// @lc code=start
/**
 * @param {string} text
 * @param {string} brokenLetters
 * @return {number}
 */
var canBeTypedWords = function(text, brokenLetters) {
    const brokenSet = new Set(brokenLetters);

    const words = text.split(' ');
    let count = 0;

    for (let word of words) {
        let canType = true;

        for (let ch of word) {
            if (brokenSet.has(ch)) {
                canType = false;
                break;
            }
        }

        if (canType) {
            count++;
        }
    }

    return count;
};
// @lc code=end

