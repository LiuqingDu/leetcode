/*
 * @lc app=leetcode.cn id=645 lang=javascript
 *
 * [645] 错误的集合
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number[]}
 */
var findErrorNums = function(nums) {

    let res = [];
    let n = nums.length;
    for (let i = 0; i < n; i++) {
        let num = Math.abs(nums[i]);
        let j = nums[num - 1];
        if (j < 0) {
            res[0] = num;
        } else {
            nums[num - 1]*=-1;
        }
    }
    for (let i = 0; i < n; i++) {
        if (nums[i] > 0) {
            res[1] = i + 1;
        }
    }

    return res;
};
// @lc code=end

