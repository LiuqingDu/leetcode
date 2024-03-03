/*
 * @lc app=leetcode.cn id=42 lang=javascript
 *
 * [42] 接雨水
 */

// @lc code=start
/**
 * @param {number[]} height
 * @return {number}
 */
var trap = function(height) {

    let res = 0;
    let queue = [];

    for (let i = 0; i < height.length; i++) {
        while (queue.length && height[i] > height[queue[queue.length - 1]]) {
            let bottomHeight = height[queue.pop()];
            if (!queue.length) {
                break;
            }
            let distance = i - queue[queue.length - 1] - 1;
            let minWall = Math.min(height[i], height[queue[queue.length - 1]]);
            res += distance * (minWall - bottomHeight);
        }
        queue.push(i);
    }

    return res;

};
// @lc code=end

