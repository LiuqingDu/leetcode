/*
 * @lc app=leetcode.cn id=77 lang=javascript
 *
 * [77] 组合
 */

// @lc code=start
/**
 * @param {number} n
 * @param {number} k
 * @return {number[][]}
 */
var combine = function(n, k) {

    let res = [];
    let current = [];

    let backtrack = function(index) {
        if (current.length === k) {
            res.push([...current]);
            return;
        }

        for (let i = index; i <= n; i++) {
            current.push(i);
            backtrack(i + 1);
            current.pop();
        }
    }

    backtrack(1);

    return res;

};
// @lc code=end

