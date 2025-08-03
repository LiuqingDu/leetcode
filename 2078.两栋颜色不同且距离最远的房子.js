/*
 * @lc app=leetcode.cn id=2078 lang=javascript
 *
 * [2078] 两栋颜色不同且距离最远的房子
 */

// @lc code=start
/**
 * @param {number[]} colors
 * @return {number}
 */
var maxDistance = function(colors) {
    let n = colors.length;
    let left = 0, right = n - 1;
    while (right >= 0 && colors[0] === colors[right]) {
        right--;
    }
    while (left < n && colors[n - 1] === colors[left]) {
        left++;
    }
    return Math.max(n - 1 - left, right);
};
// @lc code=end

