/*
 * @lc app=leetcode.cn id=462 lang=javascript
 *
 * [462] 最小操作次数使数组元素相等 II
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var minMoves2 = function(nums) {
    nums.sort((a, b) => a - b);
    
    const median = nums[Math.floor(nums.length / 2)];
    
    let moves = 0;
    for (let num of nums) {
        moves += Math.abs(num - median);
    }
    
    return moves;
};
// @lc code=end

