/*
 * @lc app=leetcode.cn id=769 lang=javascript
 *
 * [769] 最多能完成排序的块
 */

// @lc code=start
/**
 * @param {number[]} arr
 * @return {number}
 */
var maxChunksToSorted = function(arr) {
    let res = 0;
    let max = 0;
    for (let i = 0; i < arr.length; i++) {
        max = Math.max(max, arr[i]);
        if (max === i) {
            res++;
        }
    }
    return res;
};
// @lc code=end

