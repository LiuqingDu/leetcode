/*
 * @lc app=leetcode.cn id=1013 lang=javascript
 *
 * [1013] 将数组分成和相等的三个部分
 */

// @lc code=start
/**
 * @param {number[]} arr
 * @return {boolean}
 */
var canThreePartsEqualSum = function(arr) {
    let n = arr.length;
    for (let i = 1; i < n; i++) {
        arr[i] += arr[i - 1];
    }
    if (arr[n - 1] % 3 !== 0) {
        return false;
    }
    let sum = arr[n - 1] / 3;
    let times = 1;
    for (let i = 0; i < n-1 && times < 3; i++) {
        if (arr[i] === sum * times) {
            times++;
        }
    }
    return times === 3;
};
// @lc code=end

