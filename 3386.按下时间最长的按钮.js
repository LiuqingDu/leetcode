/*
 * @lc app=leetcode.cn id=3386 lang=javascript
 *
 * [3386] 按下时间最长的按钮
 */

// @lc code=start
/**
 * @param {number[][]} events
 * @return {number}
 */
var buttonWithLongestTime = function(events) {
    let index = events[0][0];
    let maxDiff = events[0][1];

    for (let i = 1; i < events.length; i++) {
        let p = events[i - 1];
        let q = events[i];

        let d = q[1] - p[1];
        if (d > maxDiff || d === maxDiff && q[0] < index) {
            index = q[0];
            maxDiff = d;
        }
    }

    return index;
};
// @lc code=end

