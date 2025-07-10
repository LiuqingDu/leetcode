/*
 * @lc app=leetcode.cn id=939 lang=javascript
 *
 * [939] 最小面积矩形
 */

// @lc code=start
/**
 * @param {number[][]} points
 * @return {number}
 */
var minAreaRect = function(points) {
    const pointSet = new Set(points.map(p => p.join(',')));
    let minArea = Infinity;

    for (let i = 0; i < points.length; i++) {
        for (let j = i + 1; j < points.length; j++) {
            const [x1, y1] = points[i];
            const [x2, y2] = points[j];

            if (x1 !== x2 && y1 !== y2) {
                if (pointSet.has(`${x1},${y2}`) && pointSet.has(`${x2},${y1}`)) {
                    const area = Math.abs(x1 - x2) * Math.abs(y1 - y2);
                    minArea = Math.min(minArea, area);
                }
            }
        }
    }

    return minArea === Infinity ? 0 : minArea;
};
// @lc code=end

