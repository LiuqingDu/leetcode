/*
 * @lc app=leetcode.cn id=554 lang=javascript
 *
 * [554] 砖墙
 */

// @lc code=start
/**
 * @param {number[][]} wall
 * @return {number}
 */
var leastBricks = function(wall) {
    const n = wall.length;
    const map = new Map();
    for (let i = 0; i < n; i++) {
        let sum = 0;
        for (const cur of wall[i]) {
            sum += cur;
            map.set(sum, (map.get(sum) || 0) + 1);
        }
        map.delete(sum);
    }
    const maxValue = Math.max(0, ...map.values());
    return n - maxValue;
};
// @lc code=end

