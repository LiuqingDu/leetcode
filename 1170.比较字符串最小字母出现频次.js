/*
 * @lc app=leetcode.cn id=1170 lang=javascript
 *
 * [1170] 比较字符串最小字母出现频次
 */

// @lc code=start
/**
 * @param {string[]} queries
 * @param {string[]} words
 * @return {number[]}
 */
var numSmallerByFrequency = function(queries, words) {
    function f(s) {
        let cnt = 0;
        let ch = 'z';
        for (let c of s) {
        if (c < ch) {
            ch = c;
            cnt = 1;
        } else if (c == ch) {
            cnt++;
        }
        }
        return cnt;
    }

    let count = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
    for (let s of words) {
      count[f(s)]++;
    }
    for (let i = 9; i >= 0; i--) {
      count[i] += count[i + 1];
    }
    res = [];
    for (let s of queries) {
      res.push(count[f(s) + 1]);
    }
    return res;
};
// @lc code=end

