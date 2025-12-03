/*
 * @lc app=leetcode.cn id=2562 lang=javascript
 *
 * [2562] 找出数组的串联值
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var findTheArrayConcVal = function(nums) {
    let ans = 0;
    for (let i = 0, j = nums.length - 1; i <= j; i++, j--) {
        if (i < j) {
            ans += parseInt(nums[i].toString() + nums[j].toString());
        } else {
            ans += nums[i];
        }
    }
    return ans
};
// @lc code=end

