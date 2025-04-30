/*
 * @lc app=leetcode.cn id=1646 lang=javascript
 *
 * [1646] 获取生成数组中的最大值
 */

// @lc code=start
/**
 * @param {number} n
 * @return {number}
 */
var getMaximumGenerated = function(n) {
    if (n === 0) return 0;

    const nums = new Array(n + 1).fill(0);
    nums[1] = 1;

    for (let i = 1; 2 * i <= n || 2 * i + 1 <= n; i++) {
        if (2 * i <= n) {
            nums[2 * i] = nums[i];
        }
        if (2 * i + 1 <= n) {
            nums[2 * i + 1] = nums[i] + nums[i + 1];
        }
    }

    return Math.max(...nums);
};
// @lc code=end

