/*
 * @lc app=leetcode.cn id=3200 lang=javascript
 *
 * [3200] 三角形的最大高度
 */

// @lc code=start
/**
 * @param {number} red
 * @param {number} blue
 * @return {number}
 */
var maxHeightOfTriangle = function(red, blue) {
    
    const maxHeight = (x, y) => {
        for (let i = 1;; i++) {
            if (i % 2 === 1) {
                x -= i;
                if (x < 0) {
                    return i - 1;
                }
            } else {
                y -= i;
                if (y < 0) {
                    return i - 1;
                }
            }
        }
    }

    return Math.max(maxHeight(red, blue), maxHeight(blue, red));

};
// @lc code=end

