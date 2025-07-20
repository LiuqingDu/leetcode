/*
 * @lc app=leetcode.cn id=1144 lang=javascript
 *
 * [1144] 递减元素使数组呈锯齿状
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var movesToMakeZigzag = function(nums) {
    let help = function(nums, index) {
        let count = 0;
        for (let i = index; i < nums.length; i += 2) {
            if (i > 0 && nums[i] >= nums[i - 1]) {
                count += nums[i] - nums[i - 1] + 1;
                nums[i] = nums[i - 1] - 1;
            }
            if (i < nums.length - 1 && nums[i] >= nums[i + 1]) {
                count += nums[i] - nums[i + 1] + 1;
                nums[i] = nums[i + 1] - 1;
            }
        }
        return count;
    };

    return Math.min(help(nums.slice(), 0), help(nums.slice(), 1));
};
// @lc code=end

