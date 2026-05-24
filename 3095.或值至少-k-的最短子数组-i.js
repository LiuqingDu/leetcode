/*
 * @lc app=leetcode.cn id=3095 lang=javascript
 *
 * [3095] 或值至少 K 的最短子数组 I
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var minimumSubarrayLength = function(nums, k) {
    const n = nums.length;
    let ans = Infinity;

    for (let i = 0; i < n; i++) {
        let or = 0;

        for (let j = i; j < n; j++) {
            or |= nums[j];

            if (or >= k) {
                ans = Math.min(ans, j - i + 1);
                break; // 已经满足，继续扩展只会更长
            }
        }
    }

    return ans === Infinity ? -1 : ans;
};
// @lc code=end

