/*
 * @lc app=leetcode.cn id=260 lang=javascript
 *
 * [260] 只出现一次的数字 III
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number[]}
 */
var singleNumber = function(nums) {
    let xorsum = 0;
    for (let num of nums) {
        xorsum ^= num;
    }

    let lastIndexOfOne = xorsum & (-xorsum);
    let part1 = 0;
    let part2 = 0;

    for (let num of nums) {
        if (!(num & lastIndexOfOne)) {
            part1 ^= num;
        } else {
            part2 ^= num;
        }
    }

    return [part1, part2];

};
// @lc code=end

