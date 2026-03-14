/*
 * @lc app=leetcode.cn id=1863 lang=javascript
 *
 * [1863] 找出所有子集的异或总和再求和
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var subsetXORSum = function(nums) {
    
    let sum = 0;

    function dfs(index, xor) {
        // 当前子集的 xor
        sum += xor;

        for (let i = index; i < nums.length; i++) {
            dfs(i + 1, xor ^ nums[i]);
        }
    }

    dfs(0, 0);
    return sum;
};
// @lc code=end

