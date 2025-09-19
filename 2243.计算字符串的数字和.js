/*
 * @lc app=leetcode.cn id=2243 lang=javascript
 *
 * [2243] 计算字符串的数字和
 */

// @lc code=start
/**
 * @param {string} s
 * @param {number} k
 * @return {string}
 */
var digitSum = function(s, k) {
    while (s.length > k) {
        let newS = '';
        for (let i = 0; i < s.length; i += k) {
            const segment = s.slice(i, i + k);
            const sum = segment.split('').reduce((acc, curr) => acc + Number(curr), 0);
            newS += sum.toString();
        }
        s = newS;
    }
    return s;
};
// @lc code=end

