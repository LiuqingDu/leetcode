/*
 * @lc app=leetcode.cn id=2869 lang=javascript
 *
 * [2869] 收集元素的最少操作次数
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var minOperations = function(nums, k) {
    const seen = new Array(k + 1).fill(false);
    let count = 0;

    for (let i = nums.length - 1; i >= 0; i--) {
        const x = nums[i];

        if (x >= 1 && x <= k && !seen[x]) {
            seen[x] = true;
            count++;
        }

        if (count === k) {
            return nums.length - i;
        }
    }

    return nums.length; // 理论上不会到这里
};
// @lc code=end

