/*
 * @lc app=leetcode.cn id=1365 lang=javascript
 *
 * [1365] 有多少小于当前数字的数字
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number[]}
 */
var smallerNumbersThanCurrent = function(nums) {
    let cnt = new Array(101).fill(0);
    let n = nums.length;

    for (let i = 0; i < n; i++) {
        cnt[nums[i]]++;
    }

    for (let i = 1; i <= 100; i++) {
        cnt[i] += cnt[i - 1];
    }

    let res = [];
    for (let i = 0; i < n; i++) {
        res[i] = nums[i] === 0 ? 0 : cnt[nums[i] - 1];
    }

    return res;
};
// @lc code=end

