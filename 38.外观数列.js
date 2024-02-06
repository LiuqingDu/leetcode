/*
 * @lc app=leetcode.cn id=38 lang=javascript
 *
 * [38] 外观数列
 */

// @lc code=start
/**
 * @param {number} n
 * @return {string}
 */
var countAndSay = function(n) {

    let pre = "";
    let cur = "1";

    for (let i = 1; i < n; i++) {
        pre = cur;
        cur = "";
        let start = 0;
        let end = 0;
        while (end < pre.length) {
            while (pre.charAt(start) === pre.charAt(end)) {
                end++;
            }
            cur = cur + (end - start) + pre.charAt(start);
            start = end;
        }
    }

    return cur;

};
// @lc code=end

