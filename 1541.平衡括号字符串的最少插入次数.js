/*
 * @lc app=leetcode.cn id=1541 lang=javascript
 *
 * [1541] 平衡括号字符串的最少插入次数
 */

// @lc code=start
/**
 * @param {string} s
 * @return {number}
 */
var minInsertions = function(s) {

    let res = 0;
    let need = 0;

    let n = s.length;
    for (let i = 0; i < n; i++) {
        let c = s.charAt(i);

        if (c === "(") {
            if (need % 2 === 1) {
                need--;
                res++;
            }
            need += 2;
        }
        if (c === ")") {
            need --;
            if (need < 0) {
                res++;
                need = 1;
            }
        }
    }
    return res + need;

};
// @lc code=end

