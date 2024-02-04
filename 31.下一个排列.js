/*
 * @lc app=leetcode.cn id=31 lang=javascript
 *
 * [31] 下一个排列
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var nextPermutation = function(nums) {

    let swap = function(arr, i, j) {
        let tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    
    let reverse = function(arr, i, j) {
        while (i < j) {
            let tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++;
            j--;
        }
    }

    let n = nums.length;
    let p = n - 1;
    
    while (p - 1 >= 0 && nums[p - 1] >= nums[p]) {
        p--;
    }

    if (p - 1 < 0) {
        return reverse(nums, 0, n - 1);
    }

    let pivot = p - 1;
    p = n - 1;

    while (nums[p] <= nums[pivot]) {
        p--;
    }

    swap(nums, pivot, p);
    return reverse(nums, pivot + 1, n - 1);

};
// @lc code=end

