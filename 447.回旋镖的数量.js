/*
 * @lc app=leetcode.cn id=447 lang=javascript
 *
 * [447] 回旋镖的数量
 */

// @lc code=start
/**
 * @param {number[][]} points
 * @return {number}
 */
var numberOfBoomerangs = function(points) {
    let ans = 0;
    for (const p of points) {
        const cnt = new Map();
        for (const q of points) {
            const dis = (p[0] - q[0]) * (p[0] - q[0]) + (p[1] - q[1]) * (p[1] - q[1]);
            cnt.set(dis, (cnt.get(dis) || 0) + 1);
        }
        for (const [_, m] of cnt.entries()) {
            ans += m * (m - 1);
        }
    }
    return ans;
};
// @lc code=end

