/*
 * @lc app=leetcode.cn id=962 lang=javascript
 *
 * [962] 最大宽度坡
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var maxWidthRamp = function(nums) {

    const N = nums.length;
    const B = Array.from({ length: N }, (_, i) => i);

    B.sort((i, j) => nums[i] - nums[j]);

    let ans = 0;
    let m = N;

    for (const i of B) {
        ans = Math.max(ans, i - m);
        m = Math.min(m, i);
    }

    return ans;
};
// @lc code=end

