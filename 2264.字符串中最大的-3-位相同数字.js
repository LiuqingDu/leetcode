/*
 * @lc app=leetcode.cn id=2264 lang=javascript
 *
 * [2264] 字符串中最大的 3 位相同数字
 */

// @lc code=start
/**
 * @param {string} num
 * @return {string}
 */
var largestGoodInteger = function(num) {
    let res = "";
    for (let i = 0; i < num.length - 2; i++) {
        if (num[i] === num[i + 1] && num[i + 1] === num[i + 2]) {
            let current = num.substring(i, i + 3);
            if (current > res) {
                res = current;
            }
        }
    }
    return res;
};
// @lc code=end

