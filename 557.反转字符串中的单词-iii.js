/*
 * @lc app=leetcode.cn id=557 lang=javascript
 *
 * [557] 反转字符串中的单词 III
 */

// @lc code=start
/**
 * @param {string} s
 * @return {string}
 */
var reverseWords = function(s) {
    let reverse = function(cs, l, r) {
        while (l < r) {
            let c = cs[l];
            cs[l] = cs[r];
            cs[r] = c;
            l++;
            r--;
        }
    }

    let i = 0;
    let cs = s.split("");
    let n = cs.length;
    while (i < n) {
        let start = i;
        while (i < n && cs[i] !== ' ') {
            i++;
        }
        reverse(cs, start, i - 1);
        i++;
    }
    return cs.join("");
};
// @lc code=end

