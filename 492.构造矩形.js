/*
 * @lc app=leetcode.cn id=492 lang=javascript
 *
 * [492] 构造矩形
 */

// @lc code=start
/**
 * @param {number} area
 * @return {number[]}
 */
var constructRectangle = function(area) {
    for (let i = Math.floor(Math.sqrt(area)); i >= 1; i--) {
        if (area % i === 0) {
            return [area / i, i];
        }
    }
    return [];

};
// @lc code=end

