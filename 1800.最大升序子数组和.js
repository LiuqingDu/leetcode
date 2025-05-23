/*
 * @lc app=leetcode.cn id=1800 lang=javascript
 *
 * [1800] 最大升序子数组和
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var maxAscendingSum = function(nums) {
    let res = 0;
    let l = 0;
    while (l < nums.length) {
        let cursum = nums[l++];
        while (l < nums.length && nums[l] > nums[l - 1]) {
            cursum += nums[l++];
        }
        res = Math.max(res, cursum);
    }
    return res;
};
// @lc code=end

