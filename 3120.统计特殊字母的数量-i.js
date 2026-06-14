/*
 * @lc app=leetcode.cn id=3120 lang=javascript
 *
 * [3120] 统计特殊字母的数量 I
 */

// @lc code=start
/**
 * @param {string} word
 * @return {number}
 */
var numberOfSpecialChars = function(word) {
    
    const s = new Set(word);
    let ans = 0;
    for (let i = 0; i < 26; i++) {
        const lo = String.fromCharCode(97 + i);
        const up = String.fromCharCode(65 + i);
        if (s.has(lo) && s.has(up)) {
            ans++;
        }
    }
    return ans;

};
// @lc code=end

