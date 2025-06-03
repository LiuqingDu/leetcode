/*
 * @lc app=leetcode.cn id=1560 lang=javascript
 *
 * [1560] 圆形赛道上经过次数最多的扇区
 */

// @lc code=start
/**
 * @param {number} n
 * @param {number[]} rounds
 * @return {number[]}
 */
var mostVisited = function(n, rounds) {
    const ret = [];
    const size = rounds.length;
    const start = rounds[0], end = rounds[size - 1];
    if (start <= end) {
        for (let i = start; i <= end; i++) {
            ret.push(i);
        }
    } else { // 由于题目要求按扇区大小排序，因此我们要将区间分成两部分
        for (let i = 1; i <= end; i++) {
            ret.push(i);
        }
        for (let i = start; i <= n; i++) {
            ret.push(i);
        }
    }
    return ret;
};
// @lc code=end

