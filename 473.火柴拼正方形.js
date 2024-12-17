/*
 * @lc app=leetcode.cn id=473 lang=javascript
 *
 * [473] 火柴拼正方形
 */

// @lc code=start
/**
 * @param {number[]} matchsticks
 * @return {boolean}
 */
var makesquare = function(matchsticks) {
    const totalLength = matchsticks.reduce((sum, stick) => sum + stick, 0);
    if (totalLength % 4 !== 0) return false;
    
    const sideLength = totalLength / 4;
    matchsticks.sort((a, b) => b - a);
    const sides = new Array(4).fill(0);
    
    const dfs = (index) => {
        if (index === matchsticks.length) {
            return sides[0] === sideLength && sides[1] === sideLength &&
                   sides[2] === sideLength && sides[3] === sideLength;
        }
        const currentMatch = matchsticks[index];
        for (let i = 0; i < 4; i++) {
            if (sides[i] + currentMatch > sideLength) continue;
            sides[i] += currentMatch;
            if (dfs(index + 1)) return true;
            sides[i] -= currentMatch;
            if (sides[i] === 0) break;
        }
        return false;
    };
    
    return dfs(0);
};
// @lc code=end

