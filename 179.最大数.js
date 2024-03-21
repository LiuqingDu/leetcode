/*
 * @lc app=leetcode.cn id=179 lang=javascript
 *
 * [179] 最大数
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {string}
 */
var largestNumber = function(nums) {

    nums = nums.map(a => "" + a).sort((a, b) => (b + a) - (a + b));

    if (nums[0] === "0") {
        return "0";
    }

    return nums.join("");

};
// @lc code=end

