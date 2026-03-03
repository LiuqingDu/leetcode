/*
 * @lc app=leetcode.cn id=2970 lang=javascript
 *
 * [2970] 统计移除递增子数组的数目 I
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var incremovableSubarrayCount = function(nums) {
    
    function isIncreasing(nums, l, r) {
        for (let i = 1; i < nums.length; i++) {
            if (i >= l && i <= r + 1) {
                continue;
            }
            if (nums[i] <= nums[i - 1]) {
                return false;
            }
        }
        if (l - 1 >= 0 && r + 1 < nums.length && nums[r + 1] <= nums[l - 1]) {
            return false;
        }
        return true;
    }

    let res = 0;
    for (let i = 0; i < nums.length; i++) {
        for (let j = i; j < nums.length; j++) {
            if (isIncreasing(nums, i, j)) {
                res++;
            }
        }
    }
    return res;
};
// @lc code=end

