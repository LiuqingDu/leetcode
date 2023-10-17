/*
 * @lc app=leetcode.cn id=27 lang=javascript
 *
 * [27] 移除元素
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} val
 * @return {number}
 */
var removeElement = function(nums, val) {

    let left = -1, right = 0;

    while(right < nums.length) {
        if (nums[right] === val) {
            right++;
        } else {
            nums[++left] = nums[right++];
        }
    }

    return left + 1;
};
// @lc code=end

