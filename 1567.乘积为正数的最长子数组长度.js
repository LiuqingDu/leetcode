/*
 * @lc app=leetcode.cn id=1567 lang=javascript
 *
 * [1567] 乘积为正数的最长子数组长度
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var getMaxLen = function(nums) {
    // 动态规划
    // positive[i] 表示以下标i结尾的数组乘积为正数的最大长度
    // negative[i] 同理表示下标i结尾乘积为负数的最大长度
    let length = nums.length;
    let positive = Array(length).fill(0);
    let negative = Array(length).fill(0);

    if (nums[0] > 0) {
        positive[0] = 1;
    } else if (nums[0] < 0) {
        negative[0] = 1;
    }

    let maxLength = positive[0];
    for (let i = 1; i < length; i++) {
        if (nums[i] > 0) {
            // 如果是正数，则结果为正的长度+1
            positive[i] = positive[i - 1] + 1;
            // 如果前一个下标的乘积为负的长度大于0，则该长度也可以+1，否则就保持0
            negative[i] = negative[i - 1] > 0 ? negative[i - 1] + 1 : 0;
        } else if (nums[i] < 0) {
            // 如果当前是负数，则乘积为正的长度取决于前一个负数乘积，前一个不为0则+1，为0则保持0
            positive[i] = negative[i - 1] > 0 ? negative[i - 1] + 1 : 0;
            // 如果当前是负数，则乘积为负的长度取决于前一个正数乘积，直接+1
            negative[i] = positive[i - 1] + 1;
        } else {
            positive[i] = 0;
            negative[i] = 0;
        }
        maxLength = Math.max(maxLength, positive[i]);
    }
    return maxLength;
};
// @lc code=end

