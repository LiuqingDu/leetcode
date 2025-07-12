/*
 * @lc app=leetcode.cn id=2006 lang=javascript
 *
 * [2006] 差的绝对值为 K 的数对数目
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var countKDifference = function(nums, k) {
    let count = 0;
    const numCount = new Map();
    
    for (const num of nums) {
        if (numCount.has(num - k)) {
            count += numCount.get(num - k);
        }
        if (numCount.has(num + k)) {
            count += numCount.get(num + k);
        }
        
        numCount.set(num, (numCount.get(num) || 0) + 1);
    }
    
    return count;
};
// @lc code=end

