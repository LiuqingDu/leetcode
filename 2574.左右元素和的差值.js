/*
 * @lc app=leetcode.cn id=2574 lang=javascript
 *
 * [2574] 左右元素和的差值
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number[]}
 */
var leftRightDifference = function(nums) {
    const n = nums.length;
    const answer = new Array(n);

    // 1. 计算总和
    let total = 0;
    for (let num of nums) {
        total += num;
    }

    // 2. 计算左右差值
    let leftSum = 0;
    for (let i = 0; i < n; i++) {
        const rightSum = total - leftSum - nums[i];
        answer[i] = Math.abs(leftSum - rightSum);
        leftSum += nums[i];
    }

    return answer;
};
// @lc code=end

