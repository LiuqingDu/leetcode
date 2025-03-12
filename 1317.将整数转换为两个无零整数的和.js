/*
 * @lc app=leetcode.cn id=1317 lang=javascript
 *
 * [1317] 将整数转换为两个无零整数的和
 */

// @lc code=start
/**
 * @param {number} n
 * @return {number[]}
 */
var getNoZeroIntegers = function(n) {
    let res = [0, 0];
    
    if (n <= 10) {
        res[0] = 1;
        res[1] = n - 1;
        return res;
    }

    let length = Math.floor(Math.log10(n));
    res[0] = Math.pow(10, length) - 1;
    res[1] = n - res[0];

    let temp = res[1];
    let index = 1;

    while (temp > 0) {
        if (temp % 10 === 0) {
            res[0] -= index;
            res[1] += index;
        }
        index *= 10;
        temp = Math.floor(temp / 10);
    }

    return res;
};
// @lc code=end

