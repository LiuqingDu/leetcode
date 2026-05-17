/*
 * @lc app=leetcode.cn id=1347 lang=javascript
 *
 * [1347] 制造字母异位词的最小步骤数
 */

// @lc code=start
/**
 * @param {string} s
 * @param {string} t
 * @return {number}
 */
var minSteps = function(s, t) {
    // 26个字母计数
    const count = new Array(26).fill(0);

    // s中的字母 +1
    for (let c of s) {
        count[c.charCodeAt() - 97]++;
    }

    // t中的字母 -1
    for (let c of t) {
        count[c.charCodeAt() - 97]--;
    }

    let ans = 0;

    // 统计 s 比 t 多出的字母数量
    for (let num of count) {
        if (num > 0) {
            ans += num;
        }
    }

    return ans;
};
// @lc code=end

