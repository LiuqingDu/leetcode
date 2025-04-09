/*
 * @lc app=leetcode.cn id=1502 lang=javascript
 *
 * [1502] 判断能否形成等差数列
 */

// @lc code=start
/**
 * @param {number[]} arr
 * @return {boolean}
 */
var canMakeArithmeticProgression = function(arr) {
    arr.sort((a, b) => a - b);
    let dif = arr[1] - arr[0];
    let n = arr.length;
    for (let i = 1; i < n - 1; i++) {
        if (arr[i + 1] - arr[i] !== dif) {
            return false;
        }
    }
    return true;
};
// @lc code=end

