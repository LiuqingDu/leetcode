/*
 * @lc app=leetcode.cn id=667 lang=javascript
 *
 * [667] 优美的排列 II
 */

// @lc code=start
/**
 * @param {number} n
 * @param {number} k
 * @return {number[]}
 */
var constructArray = function(n, k) {
    let left = 1, right = n;
    let index = 0;
    let res = new Array(n).fill(0);

    for (let i = 0; i < k; i++) {
        if (i % 2 === 0) {
            res[index] = left;
            index++;
            left++;
        } else {
            res[index] = right;
            index++;
            right--;
        }
    }

    if (k % 2 === 0) {
        while (left <= right) {
            res[index] = right;
            index++;
            right--;
        }
    } else {
        while (left <= right) {
            res[index] = left;
            index++;
            left++;
        }
    }

    return res;
};
// @lc code=end

