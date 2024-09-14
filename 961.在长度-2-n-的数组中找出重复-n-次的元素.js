/*
 * @lc app=leetcode.cn id=961 lang=javascript
 *
 * [961] 在长度 2N 的数组中找出重复 N 次的元素
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var repeatedNTimes = function(nums) {
    for (let i = 0; i < nums.length; i++) {
        if (i >= 1 && nums[i - 1] === nums[i]) {
            return nums[i];
        }
        if (i >= 2 && nums[i - 2] === nums[i]) {
            return nums[i];
        }
        if (i >= 3 && nums[i - 3] === nums[i]) {
            return nums[i];
        }
    }
    return 0;
};
// @lc code=end

