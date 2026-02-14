/*
 * @lc app=leetcode.cn id=2932 lang=javascript
 *
 * [2932] 找出强数对的最大异或值 I
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var maximumStrongPairXor = function(nums) {
    let max = 0;
    const n = nums.length;

    for (let i = 0; i < n; i++) {
        for (let j = 0; j < n; j++) {
            let x = nums[i];
            let y = nums[j];

            // 判断是否为强数对
            if (Math.abs(x - y) <= Math.min(x, y)) {
                max = Math.max(max, x ^ y);
            }
        }
    }

    return max;
};
// @lc code=end

