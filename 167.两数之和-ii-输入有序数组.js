/*
 * @lc app=leetcode.cn id=167 lang=javascript
 *
 * [167] 两数之和 II - 输入有序数组
 */

// @lc code=start
/**
 * @param {number[]} numbers
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(numbers, target) {
    let n = numbers.length;
    let ind1 = 0, ind2 = n - 1;

    while (ind1 < ind2) {
        let sum = numbers[ind1] + numbers[ind2];
        if (sum === target) {
            return [ind1 + 1, ind2 + 1];
        } else if (sum < target) {
            ind1++;
        } else if (sum > target) {
            ind2--;
        }
    }

};
// @lc code=end

