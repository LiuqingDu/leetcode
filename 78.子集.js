/*
 * @lc app=leetcode.cn id=78 lang=javascript
 *
 * [78] 子集
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var subsets = function(nums) {

    nums.sort((a, b) => a - b);

    let res = [];

    let current = [];

    let backtrack = function(index) {
        res.push([...current]);
        if (index === nums.length) {
            return;
        }

        for (let i = index; i < nums.length; i++) {
            current.push(nums[i]);
            backtrack(i + 1);
            current.pop();
        }
    }

    backtrack(0);

    return res;

};
// @lc code=end

