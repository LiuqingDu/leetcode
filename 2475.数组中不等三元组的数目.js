/*
 * @lc app=leetcode.cn id=2475 lang=javascript
 *
 * [2475] 数组中不等三元组的数目
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var unequalTriplets = function(nums) {
    let res = 0, n = nums.length;
    for (let i = 0; i < n; i++) {
        for (let j = i + 1; j < n; j++) {
            for (let k = j + 1; k < n; k++) {
                if (nums[i] != nums[j] && nums[i] != nums[k] && nums[j] != nums[k]) {
                    res++;
                }
            }
        }
    }
    return res;
};
// @lc code=end

