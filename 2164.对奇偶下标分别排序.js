/*
 * @lc app=leetcode.cn id=2164 lang=javascript
 *
 * [2164] 对奇偶下标分别排序
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number[]}
 */
var sortEvenOdd = function(nums) {
    // 提取奇数和偶数下标的元素
    let even = [];
    let odd = [];
    for (let i = 0; i < nums.length; i++) {
        if (i % 2 === 0) {
            even.push(nums[i]);
        } else {
            odd.push(nums[i]);
        }
    }
    // 对偶数下标的元素进行升序排序
    even.sort((a, b) => a - b);
    // 对奇数下标的元素进行降序排序
    odd.sort((a, b) => b - a);
    // 合并结果
    let result = [];
    for (let i = 0; i < nums.length; i++) {
        if (i % 2 === 0) {
            result.push(even[i / 2]);
        } else {
            result.push(odd[(i - 1) / 2]);
        }
    }
    return result;
};
// @lc code=end

