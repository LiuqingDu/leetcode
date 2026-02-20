/*
 * @lc app=leetcode.cn id=2951 lang=javascript
 *
 * [2951] 找出峰值
 */

// @lc code=start
/**
 * @param {number[]} mountain
 * @return {number[]}
 */
var findPeaks = function(mountain) {
    let res = [];
    for (let i = 1; i < mountain.length - 1; i++) {
        if (mountain[i - 1] < mountain[i] && mountain[i] > mountain[i + 1]) {
            res.push(i);
        }
    }
    return res;
};
// @lc code=end

