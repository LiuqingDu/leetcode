/*
 * @lc app=leetcode.cn id=922 lang=javascript
 *
 * [922] 按奇偶排序数组 II
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number[]}
 */
var sortArrayByParityII = function(nums) {
    let n = nums.length;
    let i = 0, j = 1;
    while (i < n && j < n) {
        while (i < n && nums[i] % 2 === 0) {
            i += 2;
        }
        while (j < n && nums[j] % 2 !== 0) {
            j += 2;
        }
        if (i < n && j < n) {
            let t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }

        i += 2;
        j += 2;
    }

    return nums;
};
// @lc code=end

