/*
 * @lc app=leetcode.cn id=1288 lang=javascript
 *
 * [1288] 删除被覆盖区间
 */

// @lc code=start
/**
 * @param {number[][]} intervals
 * @return {number}
 */
var removeCoveredIntervals = function(intervals) {
    
    // 1. 排序：左升序，右降序
    intervals.sort((a, b) => {
        if (a[0] === b[0]) {
            return b[1] - a[1]; // 右端点降序
        }
        return a[0] - b[0]; // 左端点升序
    });

    let count = 0;
    let maxRight = 0;

    // 2. 遍历
    for (let [left, right] of intervals) {
        if (right > maxRight) {
            // 没被覆盖
            count++;
            maxRight = right;
        }
        // 否则就是被覆盖
    }

    return count;
};
// @lc code=end

