/*
 * @lc app=leetcode.cn id=1043 lang=javascript
 *
 * [1043] 分隔数组以得到最大和
 */

// @lc code=start
/**
 * @param {number[]} arr
 * @param {number} k
 * @return {number}
 */
var maxSumAfterPartitioning = function(arr, k) {
    
    const n = arr.length;
    const d = new Array(n + 1).fill(0);
    for (let i = 1; i <= n; i++) {
        let maxValue = arr[i - 1];
        for (let j = i - 1; j >= Math.max(0, i - k); j--) {
            d[i] = Math.max(d[i], d[j] + maxValue * (i - j));
            if (j > 0) {
                maxValue = Math.max(maxValue, arr[j - 1]);
            }
        }
    }
    return d[n];

};
// @lc code=end

