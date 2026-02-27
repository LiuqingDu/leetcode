/*
 * @lc app=leetcode.cn id=2900 lang=javascript
 *
 * [2900] 最长相邻不相等子序列 I
 */

// @lc code=start
/**
 * @param {string[]} words
 * @param {number[]} groups
 * @return {string[]}
 */
var getLongestSubsequence = function(words, groups) {
    let result = [];
    let prev = -1; // 表示还没选过
    
    for (let i = 0; i < words.length; i++) {
        
        if (groups[i] !== prev) {
            result.push(words[i]);
            prev = groups[i];
        }
    }
    
    return result;
};
// @lc code=end

