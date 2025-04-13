/*
 * @lc app=leetcode.cn id=1408 lang=javascript
 *
 * [1408] 数组中的字符串匹配
 */

// @lc code=start
/**
 * @param {string[]} words
 * @return {string[]}
 */
var stringMatching = function(words) {
    const ans = new Array()
    const n = words.length
    for (let i = 0; i < n; i++) {
        for (let j = 0; j < n; j++) {
            if (i == j) {
                continue
            }
            if (words[j].indexOf(words[i]) >= 0) {
                ans.push(words[i])
                break
            }
        }
    }
    return ans
};
// @lc code=end

