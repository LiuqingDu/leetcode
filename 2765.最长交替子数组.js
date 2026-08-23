/*
 * @lc app=leetcode.cn id=2765 lang=javascript
 *
 * [2765] 最长交替子数组
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var alternatingSubarray = function(nums) {
    let res = -1;
    let n = nums.length;

    for (let firstIndex = 0; firstIndex < n; firstIndex++) {
        for (let i = firstIndex + 1; i < n; i++) {
            let length = i - firstIndex + 1;
            if (nums[i] - nums[firstIndex] === (length - 1) % 2) {
                res = Math.max(res, length);
            } else {
                break;
            }
        }
    }

    return res;
};
// @lc code=end

