/*
 * @lc app=leetcode.cn id=1437 lang=javascript
 *
 * [1437] 是否所有 1 都至少相隔 k 个元素
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {boolean}
 */
var kLengthApart = function(nums, k) {
    let pre = -1;
    for (let i = 0; i < nums.length; i++) {
        if (nums[i] === 1) {
            if (pre === -1) {
                pre = i;
            } else {
                if (i - pre - 1 < k) {
                    return false;
                } else {
                    pre = i;
                }
            }
        }
    }
    return true;
};
// @lc code=end

