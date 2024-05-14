/*
 * @lc app=leetcode.cn id=169 lang=javascript
 *
 * [169] 多数元素
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var majorityElement = function(nums) {

    let winner = nums[0];
    let count = 1;
    for (let i = 1; i < nums.length; i++) {
        if (nums[i] === winner) {
            count++;
        } else {
            if (count > 0) {
                count--;
            } else {
                winner = nums[i];
                count = 1;
            }
        }
    }

    return winner

};
// @lc code=end

