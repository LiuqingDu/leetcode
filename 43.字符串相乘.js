/*
 * @lc app=leetcode.cn id=43 lang=javascript
 *
 * [43] 字符串相乘
 */

// @lc code=start
/**
 * @param {string} num1
 * @param {string} num2
 * @return {string}
 */
var multiply = function(num1, num2) {
    if (num1 === "0" || num2 === "0") {
        return "0";
    }

    let m = num1.length, n = num2.length;
    let res = Array(m + n).fill(0);

    for (let i = m - 1; i >= 0; i--) {
        let n1 = num1.charCodeAt(i) - "0".charCodeAt(0);

        for (let j = n - 1; j >= 0; j--) {
            let n2 = num2.charCodeAt(j) - "0".charCodeAt(0);

            let sum = (res[i + j + 1] + n1 * n2);
            res[i + j + 1] = sum % 10;
            res[i + j] += Math.floor(sum / 10);
        }
    }

    let str = "";
    for (let i = 0; i < res.length; i++) {
        if (i === 0 && res[i] === 0) {
            continue;
        }
        str += res[i];
    }

    return str;
};
// @lc code=end

