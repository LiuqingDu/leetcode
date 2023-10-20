/*
 * @lc app=leetcode.cn id=46 lang=javascript
 *
 * [46] 全排列
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permute = function(nums) {

    let res = [];
    let visited = [];

    nums.sort((a, b) => a - b);

    let backtrack = function(nums, ind, arr) {
        if (arr.length === nums.length) {
            res.push([...arr]);
            return;
        }

        for (let i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr.push(nums[i]);
                backtrack(nums, i + 1, arr);
                arr.pop();
                visited[i] = false;
            }
        }
    }

    backtrack(nums, 0, []);

    return res;
};
// @lc code=end

