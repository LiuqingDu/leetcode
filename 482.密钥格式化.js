/*
 * @lc app=leetcode.cn id=482 lang=javascript
 *
 * [482] 密钥格式化
 */

// @lc code=start
/**
 * @param {string} s
 * @param {number} k
 * @return {string}
 */
var licenseKeyFormatting = function(s, k) {
    let res = "";
    for (let i = s.length - 1, count = 0; i >= 0; i--) {
        if (s.charAt(i) === "-") {
            continue;
        }
        if (count === k) {
            res += "-";
            count = 0;
        }
        res += s.charAt(i).toUpperCase();
        count++;
    }
    return res.split("").reverse().join("");
};
// @lc code=end

