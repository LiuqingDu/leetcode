/*
 * @lc app=leetcode.cn id=452 lang=javascript
 *
 * [452] 用最少数量的箭引爆气球
 */

// @lc code=start
/**
 * @param {number[][]} points
 * @return {number}
 */
var findMinArrowShots = function(points) {

    points.sort((a, b) => a[1] - b[1]);

    let res = 1;

    let right = points[0][1];

    for (let point of points) {
        if (point[0] <= right) {
            continue;
        } else {
            res++;
            right = point[1];
        }
    }

    return res;
};
// @lc code=end

