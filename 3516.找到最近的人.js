/*
 * @lc app=leetcode.cn id=3516 lang=javascript
 *
 * [3516] 找到最近的人
 */

// @lc code=start
/**
 * @param {number} x
 * @param {number} y
 * @param {number} z
 * @return {number}
 */
var findClosest = function(x, y, z) {
    let dif = Math.abs(x - z) - Math.abs(y - z);
    if (dif < 0) {
        return 1;
    } else if (dif > 0) {
        return 2;
    } else {
        return 0;
    }
};
// @lc code=end

