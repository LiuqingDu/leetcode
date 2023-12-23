/*
 * @lc app=leetcode.cn id=567 lang=javascript
 *
 * [567] 字符串的排列
 */

// @lc code=start
/**
 * @param {string} s1
 * @param {string} s2
 * @return {boolean}
 */
var checkInclusion = function(s1, s2) {

    if (s1.length > s2.length) {
        return false;
    }

    let need = Array(26).fill(0);
    let window = Array(26).fill(0);

    for (let i = 0; i < s1.length; i++) {
        need[s1.charCodeAt(i) - 97]++;
        window[s2.charCodeAt(i) - 97]++;
    }

    let left = 0;

    while(left < s2.length - s1.length) {
        if (need.join('') === window.join('')) {
            return true;
        }

        window[s2.charCodeAt(left) - 97]--;
        window[s2.charCodeAt(left + s1.length) - 97]++;
        left++;
    }

    return (need.join('') === window.join(''));
};
// @lc code=end

