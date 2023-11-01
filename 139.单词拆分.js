/*
 * @lc app=leetcode.cn id=139 lang=javascript
 *
 * [139] 单词拆分
 */

// @lc code=start
/**
 * @param {string} s
 * @param {string[]} wordDict
 * @return {boolean}
 */
var wordBreak = function(s, wordDict) {
    let set = new Set(wordDict);
    let memo = [];
    for (let i = 0; i < s.length; i++) {
        memo[i] = -1;
    }

    let canBreak = function(i) {
        if (i === s.length) {
            return true;
        }

        if (memo[i] !== -1) {
            return memo[i] === 1;
        }

        for (let len = 1; i + len <= s.length; len++) {
            let word = s.substring(i, i + len);
            if (set.has(word)) {
                let can = canBreak(i + len);
                if (can) {
                    memo[i] = 1;
                    return true;
                }
            }
        }

        memo[i] = 0;
        return false;
    }

    return canBreak(0);

};
// @lc code=end

