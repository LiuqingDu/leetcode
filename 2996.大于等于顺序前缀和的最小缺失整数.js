/*
 * @lc app=leetcode.cn id=2996 lang=javascript
 *
 * [2996] 大于等于顺序前缀和的最小缺失整数
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var missingInteger = function(nums) {
    let sum = nums[0];

    for (let i = 1; i < nums.length; i++) {
        if (nums[i] === nums[i - 1] + 1) {
            sum += nums[i];
        } else {
            break;
        }
    }

    const set = new Set(nums);

    let x = sum;
    while (set.has(x)) {
        x++;
    }

    return x;
};
// @lc code=end

