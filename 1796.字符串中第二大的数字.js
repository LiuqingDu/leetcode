/*
 * @lc app=leetcode.cn id=1796 lang=javascript
 *
 * [1796] 字符串中第二大的数字
 */

// @lc code=start
/**
 * @param {string} s
 * @return {number}
 */
var secondHighest = function(s) {
    let first = -1, second = -1;
    for (let i = 0; i < s.length; i++) {
        let c = s[i];
        if ("0" <= c && c <= "9") {
            let num = c.charCodeAt(0) - "0".charCodeAt(0);
            if (num > first) {
                second = first;
                first = num;
            } else if (num < first && num > second) {
                second = num;
            }
        }
    }
    return second;
};
// @lc code=end

