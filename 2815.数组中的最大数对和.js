/*
 * @lc app=leetcode.cn id=2815 lang=javascript
 *
 * [2815] 数组中的最大数对和
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var maxSum = function(nums) {
    const maxVal = Array(10).fill(-Infinity); // 表示不存在最大值
    let ans = -1;
    for (const v of nums) {
        let maxD = 0;
        for (let x = v; x; x = Math.floor(x / 10)) {
            maxD = Math.max(maxD, x % 10);
        }
        ans = Math.max(ans, v + maxVal[maxD]);
        maxVal[maxD] = Math.max(maxVal[maxD], v);
    }
    return ans;
};
// @lc code=end

