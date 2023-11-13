/*
 * @lc app=leetcode.cn id=204 lang=javascript
 *
 * [204] 计数质数
 */

// @lc code=start
/**
 * @param {number} n
 * @return {number}
 */
var countPrimes = function(n) {

    let arr = [];

    for (let i = 0; i < n; i++) {
        arr[i] = true;
    }

    for (let i = 2; i*i < n; i++) {
        for (let j = i; i * j < n; j++) {
            arr[i*j] = false;
        }
    }

    let res = 0;
    for (let i = 2; i < n; i++) {
        if (arr[i]) {
            res++;
        }
    }

    return res;
};
// @lc code=end

