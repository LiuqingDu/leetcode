/*
 * @lc app=leetcode.cn id=1742 lang=javascript
 *
 * [1742] 盒子中小球的最大数量
 */

// @lc code=start
/**
 * @param {number} lowLimit
 * @param {number} highLimit
 * @return {number}
 */
var countBalls = function(lowLimit, highLimit) {
    const count = new Map();
    let res = 0;
    for (let i = lowLimit; i <= highLimit; i++) {
        let box = 0, x = i;
        while (x !== 0) {
            box += x % 10;
            x = Math.floor(x / 10);
        }
        count.set(box, (count.get(box) || 0) + 1);
        res = Math.max(res, count.get(box));
    }
    return res;
};
// @lc code=end

