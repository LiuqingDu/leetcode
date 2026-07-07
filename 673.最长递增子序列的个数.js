/*
 * @lc app=leetcode.cn id=673 lang=javascript
 *
 * [673] 最长递增子序列的个数
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var findNumberOfLIS = function(nums) {
    
    if (!nums || nums.length === 0) return 0;
    
    const n = nums.length;
    // lengths[i] 记录以 nums[i] 结尾的最长递增子序列的长度
    const lengths = new Array(n).fill(1);
    // counts[i] 记录以 nums[i] 结尾的最长递增子序列的个数
    const counts = new Array(n).fill(1);
    
    let maxLength = 1; // 记录全局最长递增子序列的长度
    
    for (let i = 0; i < n; i++) {
        for (let j = 0; j < i; j++) {
            if (nums[i] > nums[j]) {
                // 情况 1：找到了一个更长的递增子序列
                if (lengths[j] + 1 > lengths[i]) {
                    lengths[i] = lengths[j] + 1;
                    counts[i] = counts[j]; // 数量直接继承自以 j 结尾的数量
                } 
                // 情况 2：找到了一个长度相同的递增子序列
                else if (lengths[j] + 1 === lengths[i]) {
                    counts[i] += counts[j]; // 数量累加
                }
            }
        }
        // 更新全局最长长度
        maxLength = Math.max(maxLength, lengths[i]);
    }
    
    let result = 0;
    // 遍历所有位置，把所有长度等于最大长度的个数加起来
    for (let i = 0; i < n; i++) {
        if (lengths[i] === maxLength) {
            result += counts[i];
        }
    }
    
    return result;
};
// @lc code=end

