/*
 * @lc app=leetcode.cn id=3452 lang=javascript
 *
 * [3452] 好数字之和
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var sumOfGoodNumbers = function(nums, k) {
    let n = nums.length;
    let res = 0;
    for (let i = 0; i < n; i++) {
        let x = nums[i];
        if ((i < k || x > nums[i - k]) && (i + k >= n || x > nums[i + k])) {
            res += x;
        }
    }
    return res;
};
// @lc code=end

