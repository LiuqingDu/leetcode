/*
 * @lc app=leetcode.cn id=2682 lang=javascript
 *
 * [2682] 找出转圈游戏输家
 */

// @lc code=start
/**
 * @param {number} n
 * @param {number} k
 * @return {number[]}
 */
var circularGameLosers = function(n, k) {
    let visit = new Array(n).fill(false);
    for (let i = k, j = 0; !visit[j]; i += k) {
        visit[j] = true;
        j = (j + i) % n;
    }
    let ans = [];
    for (let i = 0; i < n; i++) {
        if (!visit[i]) {
            ans.push(i + 1);
        }
    }
    return ans;
};
// @lc code=end

