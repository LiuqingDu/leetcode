/*
 * @lc app=leetcode.cn id=1909 lang=javascript
 *
 * [1909] 删除一个元素使数组严格递增
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {boolean}
 */
var canBeIncreasing = function(nums) {
    let count = 0;

    for (let i = 1; i < nums.length; i++) {
        if (nums[i] <= nums[i - 1]) {
            count++;
            if (count > 1) return false;

            if (i > 1 && nums[i] <= nums[i - 2]) {
                nums[i] = nums[i - 1];
            }
        }
    }

    return true;
};
// @lc code=end

