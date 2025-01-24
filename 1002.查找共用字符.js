/*
 * @lc app=leetcode.cn id=1002 lang=javascript
 *
 * [1002] 查找共用字符
 */

// @lc code=start
/**
 * @param {string[]} words
 * @return {string[]}
 */
var commonChars = function(words) {
    let minFreq = Array(26).fill(Number.MAX_SAFE_INTEGER);

    for (let word of words) {
        let freq = Array(26).fill(0);
        for (let i = 0; i < word.length; i++) {
            let ch = word.charCodeAt(i) - "a".charCodeAt(0);
            freq[ch]++;
        }
        for (let i = 0; i < 26; i++) {
            minFreq[i] = Math.min(minFreq[i], freq[i]);
        }
    }

    let res = [];
    for (let i = 0; i < 26; i++) {
        for (let j = 0; j < minFreq[i]; j++) {
            res.push(String.fromCharCode(i + "a".charCodeAt(0)));
        }
    }

    return res;
};
// @lc code=end

