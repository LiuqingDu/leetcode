/*
 * @lc app=leetcode.cn id=140 lang=javascript
 *
 * [140] 单词拆分 II
 */

// @lc code=start
/**
 * @param {string} s
 * @param {string[]} wordDict
 * @return {string[]}
 */
var wordBreak = function(s, wordDict) {

    let memo = [];

    let set = new Set(wordDict);

    let backtrack = function(i) {
        let res = [];
        if (i === s.length) {
            res.push("");
            return res;
        }

        if (memo[i]) {
            return memo[i];
        }

        for (let len = 1; i + len <= s.length; len++) {
            let word = s.substring(i, i + len);
            if (set.has(word)) {
                let sub = backtrack(i + len);
                for (let su of sub) {
                    if (su === "") {
                        res.push(word + "");
                    } else {
                        res.push(word + " " + su);
                    }
                }
            }
        }

        memo[i] = res;
        return res;

    }
    
    return backtrack(0);
};
// @lc code=end

