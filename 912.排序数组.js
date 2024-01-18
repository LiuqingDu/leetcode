/*
 * @lc app=leetcode.cn id=912 lang=javascript
 *
 * [912] 排序数组
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number[]}
 */
var sortArray = function(nums) {

    let swap = function(nums, a, b) {
        let tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    let quickSort = function(nums, left, right) {
        if (left > right) {
            return;
        }

        let random = Math.round(Math.random() * (right - left)) + left;
        swap(nums, random, left);
        let pivot = nums[left];
        let less = left;
        let more = right + 1;
        let i = left + 1;

        while (i < more) {
            if (nums[i] < pivot) {
                less++;
                swap(nums, less, i);
                i++;
            } else if (nums[i] === pivot) {
                i++;
            } else if (nums[i] > pivot) {
                more--;
                swap(nums, more, i);
            }
        }
        swap(nums, left, less);

        quickSort(nums, left, less - 1);
        quickSort(nums, more, right);

        return nums;
    }

    return quickSort(nums, 0, nums.length - 1);

};
// @lc code=end

