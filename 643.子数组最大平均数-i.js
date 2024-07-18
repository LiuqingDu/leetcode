/*
 * @lc app=leetcode.cn id=643 lang=javascript
 *
 * [643] 子数组最大平均数 I
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var findMaxAverage = function(nums, k) {
    let sum = 0;
    let ave = 0;
    let res = Number.MIN_VALUE;
    for (let i = 0; i < nums.length; i++) {
        if (i < k) {
            sum += nums[i];
            if (i === k - 1) {
                ave = sum / k;
                res = ave;
            }
        } else {
            sum -= nums[i - k];
            sum += nums[i];
            ave = sum / k;
            res = Math.max(res, ave);
        }
    }
    return res;

};
// @lc code=end

