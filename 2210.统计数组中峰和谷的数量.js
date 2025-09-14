/*
 * @lc app=leetcode.cn id=2210 lang=javascript
 *
 * [2210] 统计数组中峰和谷的数量
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var countHillValley = function(nums) {
    let n = nums.length;
    let res = 0;
    let pre = 0;
    for (let i = 0; i < n - 1; i++) {
        if (nums[i] > nums[i + 1]) {
            if (pre === -1) {
                res++;
            }
            pre = 1;
        } else if (nums[i] < nums[i + 1]) {
            if (pre === 1) {
                res++;
            }
            pre = -1;
        }
    }
    return res;
};
// @lc code=end

