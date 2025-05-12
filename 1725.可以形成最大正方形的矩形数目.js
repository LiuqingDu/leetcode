/*
 * @lc app=leetcode.cn id=1725 lang=javascript
 *
 * [1725] 可以形成最大正方形的矩形数目
 */

// @lc code=start
/**
 * @param {number[][]} rectangles
 * @return {number}
 */
var countGoodRectangles = function(rectangles) {
    let res = 0, maxLen = 0;
    for (const rectangle of rectangles) {
        const l = rectangle[0], w = rectangle[1];
        const k = Math.min(l, w);
        if (k === maxLen) {
            ++res;
        } else if (k > maxLen) {
            res = 1;
            maxLen = k;
        }
    }
    return res;
};
// @lc code=end

