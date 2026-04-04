/*
 * @lc app=leetcode.cn id=1027 lang=javascript
 *
 * [1027] 最长等差数列
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var longestArithSeqLength = function(nums) {
    
    const n = nums.length;
    
    // dp[i] 是一个 Map
    const dp = Array.from({ length: n }, () => new Map());
    
    let res = 2;
    
    for (let i = 0; i < n; i++) {
        for (let j = 0; j < i; j++) {
            const diff = nums[i] - nums[j];
            
            // 如果之前有，就接上
            const len = (dp[j].get(diff) || 1) + 1;
            
            dp[i].set(diff, len);
            
            res = Math.max(res, len);
        }
    }
    
    return res;
};
// @lc code=end

