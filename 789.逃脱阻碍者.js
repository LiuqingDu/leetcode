/*
 * @lc app=leetcode.cn id=789 lang=javascript
 *
 * [789] 逃脱阻碍者
 */

// @lc code=start
/**
 * @param {number[][]} ghosts
 * @param {number[]} target
 * @return {boolean}
 */
var escapeGhosts = function(ghosts, target) {
    
    const source = [0, 0];
    const distance = manhattanDistance(source, target);
    for (const ghost of ghosts) {
        const ghostDistance = manhattanDistance(ghost, target);
        if (ghostDistance <= distance) {
            return false;
        }
    }
    return true;
}

const manhattanDistance = (point1, point2) => {
    return Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1]);
};
// @lc code=end

