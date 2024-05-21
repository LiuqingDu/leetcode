/*
 * @lc app=leetcode.cn id=228 lang=javascript
 *
 * [228] 汇总区间
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {string[]}
 */
var summaryRanges = function(nums) {

    let res = [];
    let start = 0;
    for (let i = 0; i < nums.length; i++) {
        if (i === nums.length - 1 || nums[i + 1] !== nums[i] + 1) {
            if (start === i) {
                res.push("" + nums[start]);
            } else {
                res.push(`${nums[start]}->${nums[i]}`);
            }
            start = i + 1;
        }
    }
    return res;
};
// @lc code=end

