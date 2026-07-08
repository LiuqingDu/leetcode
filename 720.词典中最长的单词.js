/*
 * @lc app=leetcode.cn id=720 lang=javascript
 *
 * [720] 词典中最长的单词
 */

// @lc code=start
/**
 * @param {string[]} words
 * @return {string}
 */
var longestWord = function(words) {
    
    words.sort((a, b) => {
        if (a.length !== b.length) {
            return a.length - b.length;
        } else {
            return b.localeCompare(a);
        }
    })
    let longest = "";
    let candidates = new Set();
    candidates.add("");
    const n = words.length;
    for (let i = 0; i < n; i++) {
        const word = words[i];
        if (candidates.has(word.slice(0, word.length - 1))) {
            candidates.add(word);
            longest = word;
        }
    }
    return longest;
};
// @lc code=end

