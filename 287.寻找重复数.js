/*
 * @lc app=leetcode.cn id=287 lang=javascript
 *
 * [287] 寻找重复数
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var findDuplicate = function(nums) {

    let n = nums.length - 1;
    let left = 1, right = n;

    while (left < right) {
        let mid = Math.floor((left + right) / 2);
        let c = nums.filter(a => a <= mid).length;
        if (c > mid) {
            right = mid;
        } else {
            left = mid + 1;
        }
    }

    return left;

};
// @lc code=end

