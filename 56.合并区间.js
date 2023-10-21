/*
 * @lc app=leetcode.cn id=56 lang=javascript
 *
 * [56] 合并区间
 */

// @lc code=start
/**
 * @param {number[][]} intervals
 * @return {number[][]}
 */
var merge = function(intervals) {

    intervals.sort((a, b) => a[0] - b[0]);

    let res = [];

    let left = intervals[0][0];
    let right = intervals[0][1];

    for (let i = 1; i < intervals.length; i++) {
        if (intervals[i][0] <= right) {
            right = Math.max(right, intervals[i][1]);
        } else {
            res.push([left, right]);
            left = intervals[i][0];
            right = intervals[i][1];
        }
    }

    res.push([left, right]);

    return res;

};
// @lc code=end

