/*
 * @lc app=leetcode.cn id=152 lang=javascript
 *
 * [152] 乘积最大子数组
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var maxProduct = function(nums) {

    // 动态规划
    // 记dp[i]表示以第i个数结尾的数组最大乘积
    // 显然以第i个数结尾的乘积取决于以第i-1个数结尾的乘积，也就是dp[i - 1]
    // 因为此时有两个选择：
    // 1. 与前面的连续数字共同组成子数组, 乘积是dp[i - 1] * nums[i]
    // 2. 不与前面组，而是自己独立成子数组，乘积是nums[i];
    // 这样，最大值应当是max(case 1, case 2)
    // 注意这里是全为正数的情况
    // 如果出现负数，那么就需要考虑到最小值，
    // 因为最小值乘以负数就变成最大值，最大值乘以负数变成最小值
    // 同理可以维护一个dp来记录最小值

    // let n = nums.length;
    // let dpMax = Array(n).fill(1);
    // let dpMin = Array(n).fill(1);

    // let res = Number.MIN_VALUE;

    // dpMax[0] = nums[0];
    // dpMin[0] = nums[0];

    // res = nums[0];

    // for (let i = 1; i < n; i++) {
    //     if (nums[i] > 0) {
    //         // 如果是正数，那么不涉及反转dpMax和dpMin
    //         dpMax[i] = Math.max(dpMax[i - 1] * nums[i], nums[i]);
    //         dpMin[i] = Math.min(dpMin[i - 1] * nums[i], nums[i]);
    //     } else {
    //         // 如果是负数，那么最大值与当前数字相乘后变为最小值
    //         dpMax[i] = Math.max(dpMin[i - 1] * nums[i], nums[i]);
    //         dpMin[i] = Math.min(dpMax[i - 1] * nums[i], nums[i]);
    //     }
    //     // 更新最终结果
    //     res = Math.max(res, dpMax[i]);
    // }

    // return res;

    // 注意到上面的dp只涉及到自身和前一个数字，可以使用两个变量来记录，而不使用数组
    let dpMax = 1;
    let dpMin = 1;
    // JS的一个问题，Number.MIN_VALUE实际上是一个接近于0的正数，而不是一个负数
    // 因此它与-2比较的时候，最大值是0而不是-2，用下面的-Infinity则没有问题
    let res = -Infinity;

    for (let num of nums) {
        // if (num > 0) {
        //     dpMax = Math.max(dpMax * nums[i], nums[i]);
        //     dpMin = Math.min(dpMin * nums[i], nums[i]);
        // } else {
        //     dpMax = Math.max(dpMin * nums[i], nums[i]);
        //     dpMin = Math.min(dpMax * nums[i], nums[i]);
        // };

        if (num < 0) {
            [dpMax, dpMin] = [dpMin, dpMax];
        }

        dpMax = Math.max(dpMax * num, num);
        dpMin = Math.min(dpMin * num, num);

        res = Math.max(res, dpMax);
    }

    return res;
};
// @lc code=end

