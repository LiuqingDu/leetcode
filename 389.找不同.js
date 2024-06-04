/*
 * @lc app=leetcode.cn id=389 lang=javascript
 *
 * [389] 找不同
 */

// @lc code=start
/**
 * @param {string} s
 * @param {string} t
 * @return {character}
 */
var findTheDifference = function(s, t) {
    let arr = new Array(26).fill(0);
    for (let i = 0; i < s.length; i++) {
        arr[s.charCodeAt(i) - 'a'.charCodeAt(0)]++;
    }
    for (let i = 0; i < t.length; i++) {
        arr[t.charCodeAt(i) - 'a'.charCodeAt(0)]--;
    }
    for (let i = 0; i < 26; i++) {
        if (arr[i] === -1) {
            return String.fromCharCode(i + 'a'.charCodeAt(0));
        }
    }

};
// @lc code=end

