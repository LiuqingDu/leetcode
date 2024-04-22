/*
 * @lc app=leetcode.cn id=58 lang=javascript
 *
 * [58] 最后一个单词的长度
 */

// @lc code=start
/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLastWord = function(s) {
    let cs = s.split("");

    let n = cs.length;
    let i = 0;
    let cur = 0;
    let res = 0;

    while (i < n) {
        if (cs[i] !== " ") {
            cur++;
        } else {
            if (cur !==  0) {
                res = cur;
                cur = 0;
            }
        }
        i++;
    }

    if (cur !== 0) {
        res = cur;
    }

    return res;

};
// @lc code=end

