/*
 * @lc app=leetcode.cn id=2744 lang=javascript
 *
 * [2744] 最大字符串配对数目
 */

// @lc code=start
/**
 * @param {string[]} words
 * @return {number}
 */
var maximumNumberOfStringPairs = function(words) {
    const n = words.length;
    let ans = 0;
    for (let i = 0; i < n; ++i) {
        for (let j = i + 1; j < n; ++j) {
            if (words[i][0] == words[j][1] && words[i][1] == words[j][0]) {
                ++ans;
            }
        }
    }
    return ans;
};
// @lc code=end

