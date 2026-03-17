/*
 * @lc app=leetcode.cn id=2908 lang=javascript
 *
 * [2908] 元素和最小的山形三元组 I
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var minimumSum = function(nums) {
    
    const n = nums.length;
    let res = Infinity;

    // 枚举中间点 j
    for (let j = 1; j < n - 1; j++) {
        let leftMin = Infinity;
        let rightMin = Infinity;

        // 找左边最小
        for (let i = 0; i < j; i++) {
            if (nums[i] < nums[j]) {
                leftMin = Math.min(leftMin, nums[i]);
            }
        }

        // 找右边最小
        for (let k = j + 1; k < n; k++) {
            if (nums[k] < nums[j]) {
                rightMin = Math.min(rightMin, nums[k]);
            }
        }

        // 更新答案
        if (leftMin !== Infinity && rightMin !== Infinity) {
            res = Math.min(res, leftMin + nums[j] + rightMin);
        }
    }

    return res === Infinity ? -1 : res;
};
// @lc code=end

