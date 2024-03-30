/*
 * @lc app=leetcode.cn id=238 lang=javascript
 *
 * [238] 除自身以外数组的乘积
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number[]}
 */
var productExceptSelf = function(nums) {

    let n = nums.length;
    // 两个数组分别计算nums[i]左右两边的乘积
    let L = Array(n).fill(1);
    let R = Array(n).fill(1);

    // i左边的乘积等于(i-1左边的乘积)*(i-1)
    for (let i = 1; i < n; i++) {
        L[i] = L[i - 1] * nums[i - 1];
    }
    for (let i = n - 2; i >= 0; i--) {
        R[i] = R[i + 1] * nums[i + 1];
    }

    let res = Array(n);
    for (let i = 0; i < n; i++) {
        res[i] = L[i] * R[i];
    }

    return res;

};
// @lc code=end

