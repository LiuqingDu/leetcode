/*
 * @lc app=leetcode.cn id=3105 lang=javascript
 *
 * [3105] 最长的严格递增或递减子数组
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var longestMonotonicSubarray = function(nums) {
    // 当前严格递增长度
    let inc = 1;

    // 当前严格递减长度
    let dec = 1;

    // 最终答案
    let ans = 1;

    for (let i = 1; i < nums.length; i++) {

        // 严格递增
        if (nums[i] > nums[i - 1]) {
            inc++;
            dec = 1;
        }

        // 严格递减
        else if (nums[i] < nums[i - 1]) {
            dec++;
            inc = 1;
        }

        // 相等
        else {
            inc = 1;
            dec = 1;
        }

        // 更新最大值
        ans = Math.max(ans, inc, dec);
    }

    return ans;
};
// @lc code=end

