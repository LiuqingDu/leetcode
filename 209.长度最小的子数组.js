/*
 * @lc app=leetcode.cn id=209 lang=javascript
 *
 * [209] 长度最小的子数组
 */

// @lc code=start
/**
 * @param {number} target
 * @param {number[]} nums
 * @return {number}
 */
var minSubArrayLen = function(target, nums) {

    let left = 0;
    let n = nums.length;
    let sum = 0;
    let res = Number.MAX_VALUE;

    for (let right = 0; right < n; right++) {
        sum += nums[right];
        while (sum >= target) {
            res = Math.min(res, right - left + 1);
            sum -= nums[left];
            left++;
        }
    }

    return res === Number.MAX_VALUE ? 0 : res;

};
// @lc code=end

