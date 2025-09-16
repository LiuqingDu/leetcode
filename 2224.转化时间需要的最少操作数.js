/*
 * @lc app=leetcode.cn id=2224 lang=javascript
 *
 * [2224] 转化时间需要的最少操作数
 */

// @lc code=start
/**
 * @param {string} current
 * @param {string} correct
 * @return {number}
 */
var convertTime = function(current, correct) {
    const toMinutes = time => {
        const [h, m] = time.split(":").map(Number);
        return h * 60 + m;
    }
    let diff = toMinutes(correct) - toMinutes(current);
    const ops = [60, 15, 5, 1];
    let res = 0;
    for (const op of ops) {
        res += Math.floor(diff / op);
        diff %= op;
    }
    return res;
};
// @lc code=end

