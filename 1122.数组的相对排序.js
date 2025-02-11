/*
 * @lc app=leetcode.cn id=1122 lang=javascript
 *
 * [1122] 数组的相对排序
 */

// @lc code=start
/**
 * @param {number[]} arr1
 * @param {number[]} arr2
 * @return {number[]}
 */
var relativeSortArray = function(arr1, arr2) {
    let upper = 0;
    for (let x of arr1) {
        upper = Math.max(upper, x);
    }

    let frequency = new Array(upper + 1).fill(0);
    for (let x of arr1) {
        frequency[x]++;
    }

    let ans = [];
    for (let x of arr2) {
        while (frequency[x] > 0) {
            ans.push(x);
            frequency[x]--;
        }
    }

    for (let x = 0; x <= upper; x++) {
        while (frequency[x] > 0) {
            ans.push(x);
            frequency[x]--;
        }
    }

    return ans;
};
// @lc code=end
