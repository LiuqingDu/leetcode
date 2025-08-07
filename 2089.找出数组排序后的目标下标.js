/*
 * @lc app=leetcode.cn id=2089 lang=javascript
 *
 * [2089] 找出数组排序后的目标下标
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var targetIndices = function(nums, target) {
    let lessCount = 0;
    let equalCount = 0;
    for (const num of nums) {
        if (num < target) {
            lessCount++;
        } else if (num === target) {
            equalCount++;
        }
    }
    const result = [];
    for (let i = 0; i < equalCount; i++) {
        result.push(lessCount + i);
    }
    return result;
};
// @lc code=end

