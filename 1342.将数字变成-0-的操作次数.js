/*
 * @lc app=leetcode.cn id=1342 lang=javascript
 *
 * [1342] 将数字变成 0 的操作次数
 */

// @lc code=start
/**
 * @param {number} num
 * @return {number}
 */
var numberOfSteps = function(num) {
    let getLoc = function(x) {
        for (let i = 31; i >= 0; i--) {
            if (((x >> i) & 1) === 1) return i + 1;
        }
        return -1;
    };
    
    let getCnt = function(x) {
        let ans = 0;
        for (let i = 31; i >= 0; i--) {
            if (((x >> i) & 1) === 1) ans++;
        }
        return ans;
    };
    
    return Math.max(getLoc(num) + getCnt(num) - 1, 0);
};
// @lc code=end

