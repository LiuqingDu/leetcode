/*
 * @lc app=leetcode.cn id=3127 lang=javascript
 *
 * [3127] 构造相同颜色的正方形
 */

// @lc code=start
/**
 * @param {character[][]} grid
 * @return {boolean}
 */
var canMakeSquare = function(grid) {
    let check = function(x, y) {
        let count = 0;
        
        for (let i = 0; i <= 1; i++) {
            for (let j = 0; j <= 1; j++) {
                if (grid[x + i][y + j] === 'B') {
                    count++;
                }
            }
        }
        return count !== 2;
    }

    for (let i = 0; i <= 1; i++) {
        for (let j = 0; j <= 1; j++) {
            if (check(i, j)) {
                return true ;
            }
        }
    }

    return false;
};
// @lc code=end

