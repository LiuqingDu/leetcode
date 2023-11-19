/*
 * @lc app=leetcode.cn id=216 lang=javascript
 *
 * [216] 组合总和 III
 */

// @lc code=start
/**
 * @param {number} k
 * @param {number} n
 * @return {number[][]}
 */
var combinationSum3 = function(k, n) {

    let res = [];

    let backtrack = function(k, n, path, i, sum) {
        if (k === path.length && n === sum) {
            res.push([...path]);
            return;
        }

        for (let j = i; j <= 9; j++) {
            if (sum + j <= n) {
                path.push(j);
                sum+=j;
                backtrack(k, n, path, j + 1, sum);
                sum-=j;
                path.pop();
            } else {
                continue;
            }
        }
    }

    backtrack(k, n, [], 1, 0);
    return res;
};
// @lc code=end

