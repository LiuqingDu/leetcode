5/*
 * @lc app=leetcode.cn id=1588 lang=javascript
 *
 * [1588] 所有奇数长度子数组的和
 */

// @lc code=start
/**
 * @param {number[]} arr
 * @return {number}
 */
var sumOddLengthSubarrays = function(arr) {
    const n = arr.length;
    const prefixSums = new Array(n + 1).fill(0);
    for (let i = 0; i < n; i++) {
        prefixSums[i + 1] = prefixSums[i] + arr[i];
    }
    let sum = 0;
    for (let start = 0; start < n; start++) {
        for (let length = 1; start + length <= n; length += 2) {
            const end = start + length - 1;
            sum += prefixSums[end + 1] - prefixSums[start];
        }
    }
    return sum;
};
// @lc code=end

