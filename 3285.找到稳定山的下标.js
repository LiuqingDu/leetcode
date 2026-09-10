/*
 * @lc app=leetcode.cn id=3285 lang=javascript
 *
 * [3285] 找到稳定山的下标
 */

// @lc code=start
/**
 * @param {number[]} height
 * @param {number} threshold
 * @return {number[]}
 */
var stableMountains = function(height, threshold) {
    let res = [];
    for (let i = 1; i < height.length; i++) {
        if (height[i - 1] > threshold) {
            res.push(i);
        }
    }
    return res;
};
// @lc code=end

