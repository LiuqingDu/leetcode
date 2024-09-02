/*
 * @lc app=leetcode.cn id=905 lang=javascript
 *
 * [905] 按奇偶排序数组
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number[]}
 */
var sortArrayByParity = function(nums) {
    let n = nums.length;
    let left = 0, right = 0;

    while (right < n) {
        if (nums[right] % 2 === 0) {
            let tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
        }
        right++;
    }

    return nums;
};
// @lc code=end

