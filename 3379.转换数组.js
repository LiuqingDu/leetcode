/*
 * @lc app=leetcode.cn id=3379 lang=javascript
 *
 * [3379] 转换数组
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number[]}
 */
var constructTransformedArray = function(nums) {
    
    const n = nums.length;
    const res = new Array(n);
    for (let i = 0; i < n; i++) {
        res[i] = nums[((i + nums[i]) % n + n) % n];
    }
    return res;

};
// @lc code=end

