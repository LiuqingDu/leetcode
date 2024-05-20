/*
 * @lc app=leetcode.cn id=219 lang=javascript
 *
 * [219] 存在重复元素 II
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {boolean}
 */
var containsNearbyDuplicate = function(nums, k) {
    let n = nums.length;
    
    if (k === 0) {
        return false;
    }
    
    let set = new Set();

    for (let ind = 0; ind < n; ind++) {
        if (set.size === k + 1) {
            set.delete(nums[ind - k - 1]);
        }
        if (set.has(nums[ind])) {
            return true;
        }
        set.add(nums[ind]);
    }

    return false;

};
// @lc code=end

