/*
 * @lc app=leetcode.cn id=2566 lang=javascript
 *
 * [2566] 替换一个数字后的最大差值
 */

// @lc code=start
/**
 * @param {number} num
 * @return {number}
 */
var minMaxDifference = function(num) {
    let s = num.toString();
    let t = s;
    let pos = 0;
    while (pos < s.length && s[pos] === '9') {
        pos++;
    }
    if (pos < s.length) {
        s = s.replace(new RegExp(s[pos], 'g'), '9');
    }
    t = t.replace(new RegExp(t[0], 'g'), '0');
    return parseInt(s) - parseInt(t);
};
// @lc code=end

