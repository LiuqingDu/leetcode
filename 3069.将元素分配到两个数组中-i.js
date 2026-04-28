/*
 * @lc app=leetcode.cn id=3069 lang=javascript
 *
 * [3069] 将元素分配到两个数组中 I
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number[]}
 */
var resultArray = function(nums) {
    const arr1 = [nums[0]];
    const arr2 = [nums[1]];

    for (let i = 2; i < nums.length; i++) {
        const last1 = arr1[arr1.length - 1];
        const last2 = arr2[arr2.length - 1];

        if (last1 > last2) {
            arr1.push(nums[i]);
        } else {
            arr2.push(nums[i]);
        }
    }

    return [...arr1, ...arr2];
};
// @lc code=end

