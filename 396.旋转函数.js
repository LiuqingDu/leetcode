/*
 * @lc app=leetcode.cn id=396 lang=javascript
 *
 * [396] 旋转函数
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var maxRotateFunction = function(nums) {
    let n = nums.length;
    let sumF = 0;
    let sum = 0;
    for (let i = 0; i < n; i++) {
        sumF += i * nums[i];
        sum += nums[i];
    }
    let res = sumF;
    for (let i = 0; i < n; i++) {
        sumF -= sum;
        sumF += n * nums[i];
        res = Math.max(res, sumF);
    }
    return res;
};
// @lc code=end

