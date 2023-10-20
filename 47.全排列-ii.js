/*
 * @lc app=leetcode.cn id=47 lang=javascript
 *
 * [47] 全排列 II
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permuteUnique = function(nums) {

    let res = [];
    let visited = [];

    nums.sort((a, b) => a - b);

    let backtrack = function(nums, ind, arr) {
        if (arr.length === nums.length) {
            res.push([...arr]);
            return;
        }

        for (let i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] === nums[i - 1] && !visited[i - 1]) {
                continue;
            }

            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            arr.push(nums[i]);
            backtrack(nums, i + 1, arr);
            arr.pop();
            visited[i] = false;
        }
    }

    backtrack(nums, 0, []);
    return res;

};
// @lc code=end

