/*
 * @lc app=leetcode.cn id=274 lang=javascript
 *
 * [274] H 指数
 */

// @lc code=start
/**
 * @param {number[]} citations
 * @return {number}
 */
var hIndex = function(citations) {

    let n = citations.length;

    let left = 0;
    let right = n;

    while (left < right) {
        let mid = Math.floor((left + right + 1) / 2);
        let c = citations.filter(v => v >= mid).length;

        if (c >= mid) {
            left = mid;
        } else {
            right = mid - 1;
        }

    }

    return right;

};
// @lc code=end

