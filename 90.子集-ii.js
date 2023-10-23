/*
 * @lc app=leetcode.cn id=90 lang=javascript
 *
 * [90] 子集 II
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var subsetsWithDup = function(nums) {

    nums.sort((a, b) => a - b);

    let res = [];
    let current = [];

    let backtrack = function(index) {
        res.push([...current]);
        if (index === nums.length) {
            return;
        }

        for (let i = index; i < nums.length; i++) {
            if (i > index && nums[i] === nums[i - 1]) {
                continue;
            }
            current.push(nums[i]);
            backtrack(i + 1);
            current.pop();
        }
    }

    backtrack(0);

    return res;

};
// @lc code=end

