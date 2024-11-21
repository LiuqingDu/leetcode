/*
 * @lc app=leetcode.cn id=436 lang=javascript
 *
 * [436] 寻找右区间
 */

// @lc code=start
/**
 * @param {number[][]} intervals
 * @return {number[]}
 */
var findRightInterval = function(intervals) {
    const n = intervals.length;
    const startPoints = intervals.map((interval, index) => [interval[0], index]);
    startPoints.sort((a, b) => a[0] - b[0]);
    const result = new Array(n).fill(-1);

    const binarySearch = (target) => {
        let left = 0, right = startPoints.length - 1;
        while (left <= right) {
            const mid = Math.floor((left + right) / 2);
            if (startPoints[mid][0] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left < startPoints.length ? startPoints[left][1] : -1;
    };

    for (let i = 0; i < n; i++) {
        const target = intervals[i][1];
        result[i] = binarySearch(target);
    }

    return result;
};
// @lc code=end

