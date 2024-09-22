/*
 * @lc app=leetcode.cn id=81 lang=javascript
 *
 * [81] 搜索旋转排序数组 II
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {boolean}
 */
var search = function(nums, target) {
    let l = 0, r = nums.length - 1;

    while (l <= r) {
        let mid = l + Math.floor((r - l) / 2);
        if (nums[mid] === target || nums[l] === target || nums[r] === target) {
            return true;
        } else if (nums[mid] < nums[l]) {
            if (target > nums[mid] && target < nums[r]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        } else if (nums[mid] > nums[r]) {
            if (target < nums[mid] && target > nums[l]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        } else {
            l++;
            r--;
        }
    }
    return false;

};
// @lc code=end

