/*
 * @lc app=leetcode.cn id=674 lang=javascript
 *
 * [674] 最长连续递增序列
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var findLengthOfLCIS = function(nums) {
    let res = 0;
    let l = 0;
    while (l < nums.length) {
        let r = l + 1;
        while (nums[r] > nums[r - 1] && r < nums.length) {
            r++;
        }
        res = Math.max(res, r - l);
        l = r;
    }
    return res;
};
// @lc code=end

