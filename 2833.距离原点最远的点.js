/*
 * @lc app=leetcode.cn id=2833 lang=javascript
 *
 * [2833] 距离原点最远的点
 */

// @lc code=start
/**
 * @param {string} moves
 * @return {number}
 */
var furthestDistanceFromOrigin = function(moves) {
    let left = 0;   // 尽量往左走的最终位置
    let right = 0;  // 尽量往右走的最终位置

    for (let c of moves) {
        // 尽量往左
        if (c === 'L' || c === '_') {
            left--;
        } else { // 'R'
            left++;
        }

        // 尽量往右
        if (c === 'R' || c === '_') {
            right++;
        } else { // 'L'
            right--;
        }
    }

    return Math.max(Math.abs(left), Math.abs(right));
};
// @lc code=end

