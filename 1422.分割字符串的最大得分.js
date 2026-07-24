/*
 * @lc app=leetcode.cn id=1422 lang=javascript
 *
 * [1422] 分割字符串的最大得分
 */

// @lc code=start
/**
 * @param {string} s
 * @return {number}
 */
var maxScore = function(s) {
    
    let ans = 0;
    const n = s.length;
    for (let i = 1; i < n; i++) {
        let score = 0;
        for (let j = 0; j < i; j++) {
            if (s[j] === '0') {
                score++;
            }
        }
        for (let j = i; j < n; j++) {
            if (s[j] === '1') {
                score++;
            }
        }
        ans = Math.max(ans, score);
    }
    return ans;
};
// @lc code=end

