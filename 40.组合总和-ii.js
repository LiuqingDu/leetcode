/*
 * @lc app=leetcode.cn id=40 lang=javascript
 *
 * [40] 组合总和 II
 */

// @lc code=start
/**
 * @param {number[]} candidates
 * @param {number} target
 * @return {number[][]}
 */
var combinationSum2 = function(candidates, target) {

    let res = [];

    candidates.sort((a, b) => a - b);

    let backtrack = function(nums, target, cur, arr, sum) {
        if (sum === target) {
            res.push([...arr]);
            return;
        }

        if (sum > target) {
            return;
        }

        for (let i = cur; i < nums.length; i++) {
            if (i > cur && nums[i] === nums[i - 1]) {
                continue;
            }
            arr.push(nums[i]);
            sum += nums[i];
            backtrack(nums, target, i + 1, arr, sum);
            sum -= nums[i];
            arr.pop();
        }
    }

    backtrack(candidates, target, 0, [], 0);

    return res;

};
// @lc code=end

