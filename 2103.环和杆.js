/*
 * @lc app=leetcode.cn id=2103 lang=javascript
 *
 * [2103] 环和杆
 */

// @lc code=start
/**
 * @param {string} rings
 * @return {number}
 */
var countPoints = function(rings) {
    const n = 10;
    const rods = Array.from({ length: n }, () => new Set());

    for (let i = 0; i < rings.length; i += 2) {
        const color = rings[i];
        const rodIndex = rings[i + 1].charCodeAt(0) - '0'.charCodeAt(0);
        rods[rodIndex].add(color);
    }

    return rods.reduce((count, rod) => count + (rod.size === 3 ? 1 : 0), 0);
};
// @lc code=end

