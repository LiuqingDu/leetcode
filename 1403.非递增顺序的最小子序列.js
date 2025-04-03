/*
 * @lc app=leetcode.cn id=1403 lang=javascript
 *
 * [1403] 非递增顺序的最小子序列
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number[]}
 */
var minSubsequence = function(nums) {
    const total = nums.reduce((pre, cur) => pre + cur);
    nums.sort((a, b) => a - b);
    const ans = [];
    let curr = 0;
    for (let i = nums.length - 1; i >= 0; --i) {
        curr += nums[i];
        ans.push(nums[i]);
        if (total - curr < curr) {
            break;
        }
    }
    return ans;
};
// @lc code=end

