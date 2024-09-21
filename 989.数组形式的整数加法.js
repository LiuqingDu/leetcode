/*
 * @lc app=leetcode.cn id=989 lang=javascript
 *
 * [989] 数组形式的整数加法
 */

// @lc code=start
/**
 * @param {number[]} num
 * @param {number} k
 * @return {number[]}
 */
var addToArrayForm = function(num, k) {
    let i = num.length - 1;
    while (k !== 0) {
        if (i < 0) {
            num.unshift(0);
            i = 0;
        }
        let sum = k + num[i];
        num[i] = sum % 10;
        k = Math.floor(sum / 10);
        i--;
    }

    return num;
};
// @lc code=end

