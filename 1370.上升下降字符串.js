/*
 * @lc app=leetcode.cn id=1370 lang=javascript
 *
 * [1370] 上升下降字符串
 */

// @lc code=start
/**
 * @param {string} s
 * @return {string}
 */
var sortString = function(s) {
    let bucket = new Array(26).fill(0);
    let n = s.length;
    let res = [];

    for (let c of s) {
        bucket[c.charCodeAt(0) - "a".charCodeAt(0)]++;
    }

    let i = 0;

    while (i < n) {
        for (let ind = 0; ind < 26; ind++) {
            if (bucket[ind] > 0) {
                res[i] = String.fromCharCode(ind + "a".charCodeAt(0));
                i++;
                bucket[ind]--;
            }
        }
        for (let ind = 25; ind >= 0; ind--) {
            if (bucket[ind] > 0) {
                res[i] = String.fromCharCode(ind + "a".charCodeAt(0));
                i++;
                bucket[ind]--;
            }
        }
    }

    return res.join("");
};
// @lc code=end

