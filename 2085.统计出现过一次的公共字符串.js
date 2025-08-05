/*
 * @lc app=leetcode.cn id=2085 lang=javascript
 *
 * [2085] 统计出现过一次的公共字符串
 */

// @lc code=start
/**
 * @param {string[]} words1
 * @param {string[]} words2
 * @return {number}
 */
var countWords = function(words1, words2) {
    let count1 = {}, count2 = {};
    for (let word of words1) {
        count1[word] = (count1[word] || 0) + 1;
    }
    for (let word of words2) {
        count2[word] = (count2[word] || 0) + 1;
    }
    let result = 0;
    for (let word in count1) {
        if (count1[word] === 1 && count2[word] === 1) {
            result++;
        }
    }
    return result;
};
// @lc code=end

