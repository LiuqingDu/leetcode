/*
 * @lc app=leetcode.cn id=477 lang=javascript
 *
 * [477] 汉明距离总和
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var totalHammingDistance = function(nums) {
    let total = 0;
    const n = nums.length;

    for (let i = 0; i < 32; i++) {
        let countOnes = 0;

        for (const num of nums) {
            countOnes += (num >> i) & 1;
        }

        const countZeros = n - countOnes;
        total += countOnes * countZeros;
    }

    return total;
};
// @lc code=end

