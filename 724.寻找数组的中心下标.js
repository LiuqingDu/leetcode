/*
 * @lc app=leetcode.cn id=724 lang=javascript
 *
 * [724] 寻找数组的中心下标
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var pivotIndex = function(nums) {

    let sum = 0;

    for (let num of nums) {
        sum += num;
    }

    let left = 0;
    let right = sum;
    let pivot = 0;

    while (pivot < nums.length) {
        right -= nums[pivot];
        if (left === right) {
            return pivot;
        }
        pivot += 1;
        left += nums[pivot - 1];
    }

    return -1;
};
// @lc code=end

