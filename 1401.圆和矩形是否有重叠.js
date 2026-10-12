/*
 * @lc app=leetcode.cn id=1401 lang=javascript
 *
 * [1401] 圆和矩形是否有重叠
 */

// @lc code=start
/**
 * @param {number} radius
 * @param {number} xCenter
 * @param {number} yCenter
 * @param {number} x1
 * @param {number} y1
 * @param {number} x2
 * @param {number} y2
 * @return {boolean}
 */
var checkOverlap = function(radius, xCenter, yCenter, x1, y1, x2, y2) {
    // 将圆心分别向 x 和 y 区间做 clamp 投影，得到矩形内离圆心最近的点
    const nearestX = Math.max(x1, Math.min(xCenter, x2));
    const nearestY = Math.max(y1, Math.min(yCenter, y2));

    const dx = xCenter - nearestX;
    const dy = yCenter - nearestY;

    return dx * dx + dy * dy <= radius * radius;
};
// @lc code=end

