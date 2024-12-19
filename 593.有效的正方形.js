/*
 * @lc app=leetcode.cn id=593 lang=javascript
 *
 * [593] 有效的正方形
 */

// @lc code=start
/**
 * @param {number[]} p1
 * @param {number[]} p2
 * @param {number[]} p3
 * @param {number[]} p4
 * @return {boolean}
 */
var validSquare = function(p1, p2, p3, p4) {
    let cenToOrigin = function(point, cenX, cenY) {
        return [point[0] * 4 - cenX, point[1] * 4 - cenY];
    }
    
    let rotate90 = function(point) {
        return [-point[1], point[0]];
    }
    
    let pointToString = function(point) {
        return `${point[0]},${point[1]}`;
    }

    const cenX = p1[0] + p2[0] + p3[0] + p4[0];
    const cenY = p1[1] + p2[1] + p3[1] + p4[1];

    const points = [
        cenToOrigin(p1, cenX, cenY),
        cenToOrigin(p2, cenX, cenY),
        cenToOrigin(p3, cenX, cenY),
        cenToOrigin(p4, cenX, cenY),
    ];

    const pointSet = new Set(points.map(pointToString));

    if (pointSet.size < 4) {
        return false;
    }

    for (const point of points) {
        const rotated = rotate90(point);
        if (!pointSet.has(pointToString(rotated))) {
            return false;
        }
    }

    return true;
};
// @lc code=end

