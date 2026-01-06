/*
 * @lc app=leetcode.cn id=2739 lang=javascript
 *
 * [2739] 总行驶距离
 */

// @lc code=start
/**
 * @param {number} mainTank
 * @param {number} additionalTank
 * @return {number}
 */
var distanceTraveled = function(mainTank, additionalTank) {
    let ans = 0;
    while (mainTank >= 5) {
        mainTank -= 5;
        ans += 50;
        if (additionalTank > 0) {
            additionalTank--;
            mainTank++;
        }
    }
    return ans + mainTank * 10;
};
// @lc code=end

