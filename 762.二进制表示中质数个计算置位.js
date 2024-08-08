/*
 * @lc app=leetcode.cn id=762 lang=javascript
 *
 * [762] 二进制表示中质数个计算置位
 */

// @lc code=start
/**
 * @param {number} left
 * @param {number} right
 * @return {number}
 */
var countPrimeSetBits = function(left, right) {
    let prime = [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31]
    let hash = new Array(32).fill(false);
    for (let n of prime) {
        hash[n] = true;
    }

    let res = 0;
    for (let i = left; i <= right; i++) {
        let count = 0;
        let x = i;
        while (x !== 0) {
            x -= x & (-x);
            count++;
        }
        if (hash[count]) {
            res++;
        }
    }
    return res;
}
// @lc code=end

