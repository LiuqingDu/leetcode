/*
 * @lc app=leetcode.cn id=494 lang=javascript
 *
 * [494] 目标和
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var findTargetSumWays = function(nums, target) {

    let memo = new Map();

    let backtrace = function(nums, i, remain) {
        if (i === nums.length) {
            if (remain === 0) {
                return 1;
            } else {
                return 0;
            }
        }

        let exp = i + "," + remain;

        if (memo.has(exp)) {
            return memo.get(exp);
        }

        let res = backtrace(nums, i+1, remain - nums[i]) + backtrace(nums, i+1, remain + nums[i]);

        memo.set(exp, res);

        return res;
    }

    if (nums.length === 0) {
        return 0;
    }

    return backtrace(nums, 0, target);

};
// @lc code=end

