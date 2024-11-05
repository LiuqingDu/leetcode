/*
 * @lc app=leetcode.cn id=442 lang=javascript
 *
 * [442] 数组中重复的数据
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number[]}
 */
var findDuplicates = function(nums) {
    let n= nums.length;
    let res = [];
    for (let i = 0; i < n; i++) {
        let k = Math.abs(nums[i]);
        if (nums[k - 1] > 0) {
            nums[k - 1] = -nums[k - 1];
        } else {
            res.push(k);
        }
    }
    return res;
};
// @lc code=end

