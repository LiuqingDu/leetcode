/*
 * @lc app=leetcode.cn id=1893 lang=javascript
 *
 * [1893] 检查是否区域内所有整数都被覆盖
 */

// @lc code=start
/**
 * @param {number[][]} ranges
 * @param {number} left
 * @param {number} right
 * @return {boolean}
 */
var isCovered = function(ranges, left, right) {
    const diff = new Array(52).fill(0);
    for (const [l, r] of ranges) {
        diff[l]++;
        diff[r + 1]--;
    }
    
    let curr = 0;
    for (let i = 1; i < 51; i++) {
        curr += diff[i];
        if (left <= i && i <= right && curr <= 0) {
            return false;
        }
    }
    return true;
};
// @lc code=end

