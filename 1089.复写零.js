/*
 * @lc app=leetcode.cn id=1089 lang=javascript
 *
 * [1089] 复写零
 */

// @lc code=start
/**
 * @param {number[]} arr
 * @return {void} Do not return anything, modify arr in-place instead.
 */
var duplicateZeros = function(arr) {
    let n = arr.length;
    let i = 0, j = 0;
    while (j < n) {
        if (arr[i] === 0) {
            j++;
        }
        i++;
        j++;
    }
    i--;
    j--;

    while (i >= 0) {
        if (j < n) {
            arr[j] = arr[i];
        }

        if (arr[i] === 0) {
            j--;
            if (j >= 0) {
                arr[j] = 0;
            }
        }

        i--;
        j--;
    }
};
// @lc code=end

