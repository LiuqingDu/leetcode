/*
 * @lc app=leetcode.cn id=540 lang=javascript
 *
 * [540] 有序数组中的单一元素
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var singleNonDuplicate = function(nums) {
    let left = 0, right = nums.length - 1;
    while (left < right) {
        let mid = (right - left) / 2 + left;
        if (mid % 2 === 0) {
            if (nums[mid - 1] !== nums[mid]) {
                left = mid;
            } else {
                right = mid - 2;
            }
        } else {
            if (nums[mid - 1] === nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
    }
    return nums[left];
};
// @lc code=end

