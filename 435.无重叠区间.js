/*
 * @lc app=leetcode.cn id=435 lang=javascript
 *
 * [435] 无重叠区间
 */

// @lc code=start
/**
 * @param {number[][]} intervals
 * @return {number}
 */
var eraseOverlapIntervals = function(intervals) {

    intervals.sort((a, b) => a[1] - b[1]);

    let n = intervals.length;

    if (n === 0) {
        return 0;
    }

    let end = intervals[0][1];
    let res = 1;

    for (let i = 1; i < n; i++) {
        if (intervals[i][0] >= end) {
            res++;
            end = intervals[i][1];
        }
    }

    return n - res;
};
// @lc code=end

