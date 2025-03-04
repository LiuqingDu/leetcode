/*
 * @lc app=leetcode.cn id=1232 lang=javascript
 *
 * [1232] 缀点成线
 */

// @lc code=start
/**
 * @param {number[][]} coordinates
 * @return {boolean}
 */
var checkStraightLine = function(coordinates) {
    let n = coordinates.length;
    let x0 = coordinates[0][0], y0 = coordinates[0][1];
    let x = coordinates[1][0] - x0, y = coordinates[1][1] - y0;
    for (let i = 2; i < n; i++) {
        let xi = coordinates[i][0] - x0;
        let yi = coordinates[i][1] - y0;
        if ((x * yi - y * xi) !== 0) {
            return false;
        }
    }
    return true;
};
// @lc code=end

