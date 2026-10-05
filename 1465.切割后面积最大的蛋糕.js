/*
 * @lc app=leetcode.cn id=1465 lang=javascript
 *
 * [1465] 切割后面积最大的蛋糕
 */

// @lc code=start
/**
 * @param {number} h
 * @param {number} w
 * @param {number[]} horizontalCuts
 * @param {number[]} verticalCuts
 * @return {number}
 */
var maxArea = function(h, w, horizontalCuts, verticalCuts) {

    const MOD = 1000000007n;
    horizontalCuts.sort((a, b) => a - b);
    verticalCuts.sort((a, b) => a - b);

    function calMax(arr, board) {
        let max = arr[0]; // 从 0 到第一个切口
        for (let i = 1; i < arr.length; i++) {
            max = Math.max(max, arr[i] - arr[i - 1]);
        }

        // 最后一个切口到边界
        max = Math.max(max, board - arr[arr.length - 1]);
        return max;
    }

    const maxH = BigInt(calMax(horizontalCuts, h));
    const maxW = BigInt(calMax(verticalCuts, w));

    return Number((maxH * maxW) % MOD);
};
// @lc code=end

