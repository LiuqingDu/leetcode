/*
 * @lc app=leetcode.cn id=791 lang=javascript
 *
 * [791] 自定义字符串排序
 */

// @lc code=start
/**
 * @param {string} order
 * @param {string} s
 * @return {string}
 */
var customSortString = function(order, s) {
    
    const freq = new Array(26).fill(0);
    for (let i = 0; i < s.length; ++i) {
        const ch = s[i];
        freq[ch.charCodeAt() - 'a'.charCodeAt()]++;
    }
    let ans = '';
    for (let i = 0; i < order.length; ++i) {
        const ch = order[i];
        while (freq[ch.charCodeAt() - 'a'.charCodeAt()] > 0) {
            ans += ch;
            freq[ch.charCodeAt() - 'a'.charCodeAt()]--;
        }
    }
    for (let i = 0; i < 26; ++i) {
        while (freq[i] > 0) {
            ans += String.fromCharCode(i + 'a'.charCodeAt());
            freq[i]--;
        }
    }
    return ans;
};
// @lc code=end

