/*
 * @lc app=leetcode.cn id=2974 lang=javascript
 *
 * [2974] 最小数字游戏
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number[]}
 */
var numberGame = function(nums) {
    nums.sort((a, b) => a - b);  // 升序排序
    
    for (let i = 0; i < nums.length; i += 2) {
        // 交换相邻两个数
        [nums[i], nums[i + 1]] = [nums[i + 1], nums[i]];
    }
    
    return nums;
};
// @lc code=end

