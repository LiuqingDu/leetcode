/*
 * @lc app=leetcode.cn id=2586 lang=javascript
 *
 * [2586] 统计范围内的元音字符串数
 */

// @lc code=start
/**
 * @param {string[]} words
 * @param {number} left
 * @param {number} right
 * @return {number}
 */
var vowelStrings = function(words, left, right) {
    vowels = new Set(['a', 'e', 'i', 'o', 'u']);
    let ans = 0;
    for (let i = left; i <= right; ++i) {
        const word = words[i];
        if (vowels.has(word[0]) && vowels.has(word[word.length - 1])) {
            ans++;
        }
    }
    return ans;
};
// @lc code=end

