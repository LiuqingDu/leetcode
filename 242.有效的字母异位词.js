/*
 * @lc app=leetcode.cn id=242 lang=javascript
 *
 * [242] 有效的字母异位词
 */

// @lc code=start
/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function(s, t) {

    if (s.length !== t.length) {
        return false;
    }

    let n = s.length;
    let arr = new Array(26).fill(0);

    for (let i = 0; i < n; i++) {
        arr[s.charCodeAt(i) - 'a'.charCodeAt(0)]++;
        arr[t.charCodeAt(i) - 'a'.charCodeAt(0)]--;
    }
    for (let i = 0; i < 26; i++) {
        if (arr[i] !== 0) {
            return false;
        }
    }

    return true;
};
// @lc code=end

