768/*
 * @lc app=leetcode.cn id=1768 lang=javascript
 *
 * [1768] 交替合并字符串
 */

// @lc code=start
/**
 * @param {string} word1
 * @param {string} word2
 * @return {string}
 */
var mergeAlternately = function(word1, word2) {
    const m = word1.length, n = word2.length;
    let i = 0, j = 0;

    const ans = [];
    while (i < m || j < n) {
        if (i < m) {
            ans.push(word1[i]);
            ++i;
        }
        if (j < n) {
            ans.push(word2[j]);
            ++j;
        }
    }
    return ans.join('');
};
// @lc code=end

