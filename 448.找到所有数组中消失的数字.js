/*
 * @lc app=leetcode.cn id=448 lang=javascript
 *
 * [448] 找到所有数组中消失的数字
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number[]}
 */
var findDisappearedNumbers = function(nums) {
    let res = [];
    for (let i = 0; i < nums.length; i++) {
        let ind = Math.abs(nums[i]) - 1;
        if (nums[ind] > 0) {
            nums[ind] = -nums[ind];
        }
    }
    for (let i = 0; i < nums.length; i++) {
        if (nums[i] > 0) {
            res.push(i +1);
        }
    }
    return res;
};
// @lc code=end

