/*
 * @lc app=leetcode.cn id=26 lang=javascript
 *
 * [26] 删除有序数组中的重复项
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function(nums) {
    let left = 0, right = 1;
    let n = nums.length;

    if (n < 2) {
        return nums;
    }

    while (right < n) {
        if (nums[right] === nums[left]) {
            right++;
        } else {
            nums[++left] = nums[right++];
        }
    }
    
    return left + 1;

};
// @lc code=end

