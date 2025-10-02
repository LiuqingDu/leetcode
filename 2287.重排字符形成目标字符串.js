/*
 * @lc app=leetcode.cn id=2287 lang=javascript
 *
 * [2287] 重排字符形成目标字符串
 */

// @lc code=start
/**
 * @param {string} s
 * @param {string} target
 * @return {number}
 */
var rearrangeCharacters = function(s, target) {
    const freqS = {};
    for (let c of s) {
        freqS[c] = (freqS[c] || 0) + 1;
    }

    const freqT = {};
    for (let c of target) {
        freqT[c] = (freqT[c] || 0) + 1;
    }

    let ans = Infinity;
    for (let c in freqT) {
        if (!freqS[c]) return 0;
        ans = Math.min(ans, Math.floor(freqS[c] / freqT[c]));
    }

    return ans === Infinity ? 0 : ans;
};
// @lc code=end

