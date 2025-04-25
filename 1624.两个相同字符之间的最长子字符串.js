/*
 * @lc app=leetcode.cn id=1624 lang=javascript
 *
 * [1624] 两个相同字符之间的最长子字符串
 */

// @lc code=start
/**
 * @param {string} s
 * @return {number}
 */
var maxLengthBetweenEqualCharacters = function(s) {
    const firstIndex = new Array(26).fill(-1);
    let maxLength = -1;
    for (let i = 0; i < s.length; i++) {
        if (firstIndex[s[i].charCodeAt() - 'a'.charCodeAt()] < 0) {
            firstIndex[s[i].charCodeAt() - 'a'.charCodeAt()] = i;
        } else {
            maxLength = Math.max(maxLength, i - firstIndex[s[i].charCodeAt() - 'a'.charCodeAt()] - 1);
        }
    }
    return maxLength;
};
// @lc code=end

