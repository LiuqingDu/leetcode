/*
 * @lc app=leetcode.cn id=34 lang=javascript
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var searchRange = function(nums, target) {

    let findLeft = function(nums, target) {
        let left = 0, right = nums.length - 1;

        while (left <= right) {
            let mid = left + Math.floor((right - left) / 2);
            if (nums[mid] < target) {
                left = mid + 1;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            }
            if (nums[mid] === target) {
                right = mid - 1;
            }
        }

        if (left < 0 || left > nums.length - 1) {
            return -1;
        }

        if (nums[left] === target) {
            return left;
        } else {
            return -1;
        }
    }

    let findRight = function(nums, target) {
        let left = 0, right = nums.length - 1;

        while(left <= right) {
            let mid = left + Math.floor((right - left) / 2);
            if (nums[mid] < target) {
                left = mid + 1;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            }
            if (nums[mid] === target) {
                left = mid + 1;
            }
        }

        if (right < 0 || right > nums.length - 1) {
            return -1;
        }

        if (nums[right] === target) {
            return right;
        } else {
            return -1;
        }
    }

    return [findLeft(nums, target), findRight(nums, target)];

};
// @lc code=end

