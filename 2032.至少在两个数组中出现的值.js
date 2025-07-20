/*
 * @lc app=leetcode.cn id=2032 lang=javascript
 *
 * [2032] 至少在两个数组中出现的值
 */

// @lc code=start
/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @param {number[]} nums3
 * @return {number[]}
 */
var twoOutOfThree = function(nums1, nums2, nums3) {
    const map = new Map();
    const result = [];

    for (const num of nums1) {
        map.set(num, (map.get(num) || 0) | 1);
    }
    for (const num of nums2) {
        map.set(num, (map.get(num) || 0) | 2);
    }
    for (const num of nums3) {
        map.set(num, (map.get(num) || 0) | 4);
    }

    for (const [num, bitmask] of map.entries()) {
        if ((bitmask & (bitmask - 1)) !== 0) {
            result.push(num);
        }
    }

    return result;
};
// @lc code=end

