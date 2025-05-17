/*
 * @lc app=leetcode.cn id=1752 lang=javascript
 *
 * [1752] 检查数组是否经排序和轮转得到
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {boolean}
 */
var check = function(nums) {
    let n = nums.length;
    let count = 0;
    for (let i = 0; i < n; i++) {
        if (nums[i] > nums[(i + 1) % n]) {
            count += 1;
        }
    }
    return count <= 1;
};
// @lc code=end

