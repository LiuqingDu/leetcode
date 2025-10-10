/*
 * @lc app=leetcode.cn id=967 lang=javascript
 *
 * [967] 连续差相同的数字
 */

// @lc code=start
/**
 * @param {number} n
 * @param {number} k
 * @return {number[]}
 */
var numsSameConsecDiff = function(n, k) {
    if (n === 1) {
        return [0,1,2,3,4,5,6,7,8,9];
    }

    const res = [];

    const dfs = (len, num) => {
        if (len === 0) {
            res.push(num);
            return;
        }
        const last = num % 10;
        if (last + k < 10) {
            dfs(len - 1, num * 10 + last + k);
        }
        if (k !== 0 && last - k >= 0) {
            dfs(len - 1, num * 10 + last - k);
        }
    };

    for (let i = 1; i <= 9; i++) {
        dfs(n - 1, i);
    }

    return res;
};
// @lc code=end

