/*
 * @lc app=leetcode.cn id=2511 lang=javascript
 *
 * [2511] 最多可以摧毁的敌人城堡数目
 */

// @lc code=start
/**
 * @param {number[]} forts
 * @return {number}
 */
var captureForts = function(forts) {
    let ans = 0, pre = -1;
    for (let i = 0; i < forts.length; i++) {
        if (forts[i] == 1 || forts[i] == -1) {
            if (pre >= 0 && forts[i] != forts[pre]) {
                ans = Math.max(ans, i - pre - 1);
            }
            pre = i;
        }
    }
    return ans;
};
// @lc code=end

