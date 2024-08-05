/*
 * @lc app=leetcode.cn id=747 lang=javascript
 *
 * [747] 至少是其他数字两倍的最大数
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var dominantIndex = function(nums) {
    let m1 = 0, m2 = -1;
    for (let i = 1; i < nums.length; i++) {
        if (nums[i] > nums[m1]) {
            m2 = m1;
            m1 = i;
        } else if (m2 === -1 || nums[i] > nums[m2]) {
            m2 = i;
        }
    }
    return nums[m1] >= nums[m2] * 2 ? m1 : -1;
};
// @lc code=end

