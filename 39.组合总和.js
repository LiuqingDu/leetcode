/*
 * @lc app=leetcode.cn id=39 lang=javascript
 *
 * [39] 组合总和
 */

// @lc code=start
/**
 * @param {number[]} candidates
 * @param {number} target
 * @return {number[][]}
 */
var combinationSum = function(candidates, target) {

    candidates.sort((a, b) => b - a);

    let res = [];

    let backtrack = function(nums, target, cur, arr, sum) {
        if (sum === target) {
            res.push([...arr]);
            return;
        }

        if (sum > target) {
            return;
        }
        
        for (let i = cur; i < nums.length; i++) {
            sum += nums[i];
            arr.push(nums[i]);
            backtrack(nums, target, i, arr, sum);
            arr.pop();
            sum -= nums[i];
        }
    }

    backtrack(candidates, target, 0, [], 0);

    return res;

};
// @lc code=end

