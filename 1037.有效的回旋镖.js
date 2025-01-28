/*
 * @lc app=leetcode.cn id=1037 lang=javascript
 *
 * [1037] 有效的回旋镖
 */

// @lc code=start
/**
 * @param {number[][]} points
 * @return {boolean}
 */
var isBoomerang = function(points) {
    
    const [x1, y1] = points[0];
    const [x2, y2] = points[1];
    const [x3, y3] = points[2];

    return (y2 - y1) * (x3 - x1) !== (y3 - y1) * (x2 - x1);
};
// @lc code=end

