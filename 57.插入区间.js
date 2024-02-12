/*
 * @lc app=leetcode.cn id=57 lang=javascript
 *
 * [57] 插入区间
 */

// @lc code=start
/**
 * @param {number[][]} intervals
 * @param {number[]} newInterval
 * @return {number[][]}
 */
var insert = function(intervals, newInterval) {
    let res = [];
    let ind = 0;
    let i = 0;

    while (i < intervals.length && intervals[i][1] < newInterval[0]) {
        res.push([intervals[i][0], intervals[i][1]]);
        ind++;
        i++;
    }

    // 如果intervals[i]跟newInterval重叠，则把区间合并
    // 重叠的标准是intervals[i]的左边界小于等于newInterval的右边界
    while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
        newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
        newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
        i++;
    }
    res.push([newInterval[0], newInterval[1]]);

    while (i < intervals.length) {
        res.push([intervals[i][0], intervals[i][1]]);
        i++;
    }

    return res;

};
// @lc code=end

