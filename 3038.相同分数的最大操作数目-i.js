/*
 * @lc app=leetcode.cn id=3038 lang=javascript
 *
 * [3038] 相同分数的最大操作数目 I
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var maxOperations = function(nums) {
    
    const n = nums.length;
    
    // 第一次操作的分数
    const target = nums[0] + nums[1];
    
    let count = 1; // 至少可以操作一次
    
    // 从下标2开始，每两个一组
    for (let i = 2; i + 1 < n; i += 2) {
        if (nums[i] + nums[i + 1] === target) {
            count++;
        } else {
            break;
        }
    }
    
    return count;
};
// @lc code=end

